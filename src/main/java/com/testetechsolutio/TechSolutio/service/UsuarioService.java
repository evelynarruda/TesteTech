package com.testetechsolutio.TechSolutio.service;

import java.nio.charset.Charset;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.testetechsolutio.TechSolutio.model.UsuarioModel;
import com.testetechsolutio.TechSolutio.model.dtos.CredenciaisDTO;
import com.testetechsolutio.TechSolutio.model.dtos.UsuarioLoginDTO;
import com.testetechsolutio.TechSolutio.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	
	private static String encriptadorDeSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);

	}
	
	public Optional<Object> cadastrarUsuario(UsuarioModel usuarioParaCadastrar) {
		return repository.findByEmailUsuario(usuarioParaCadastrar.getEmailUsuario()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			usuarioParaCadastrar.setSenhaUsuario(encriptadorDeSenha(usuarioParaCadastrar.getSenhaUsuario()));
			return Optional.ofNullable(repository.save(usuarioParaCadastrar));
		});
	}
	
	public Optional<UsuarioModel> atualizarUsuario(UsuarioModel usuarioParaAtualizar) {
		return repository.findById(usuarioParaAtualizar.getIdUsuario()).map(resp -> {
			resp.setNomeUsuario(usuarioParaAtualizar.getNomeUsuario());
			resp.setSenhaUsuario(encriptadorDeSenha(usuarioParaAtualizar.getSenhaUsuario()));
			return Optional.ofNullable(repository.save(resp));
		}).orElseGet(() -> {
			return Optional.empty();
		});

	}
	
	private static String gerarToken(String email, String senha) {
		String estrutura = email + ":" + senha;
		byte[] estruturaBase64 = Base64.encodeBase64(estrutura.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(estruturaBase64);
	}

	public ResponseEntity<CredenciaisDTO> pegarCredenciais(UsuarioLoginDTO usuarioParaAutenticar) {
		return repository.findByEmailUsuario(usuarioParaAutenticar.getEmail()).map(resp -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			if (encoder.matches(usuarioParaAutenticar.getSenha(), resp.getSenhaUsuario())) {

				CredenciaisDTO objetoCredenciaisDTO = new CredenciaisDTO();

				objetoCredenciaisDTO.setToken(gerarToken(usuarioParaAutenticar.getEmail(), usuarioParaAutenticar.getSenha()));
				objetoCredenciaisDTO.setIdUsuario(resp.getIdUsuario());
				objetoCredenciaisDTO.setNomeUsuario(resp.getNomeUsuario());
				objetoCredenciaisDTO.setEmailUsuario(resp.getEmailUsuario());
				objetoCredenciaisDTO.setSenhaUsuario(resp.getSenhaUsuario());

				return ResponseEntity.status(201).body(objetoCredenciaisDTO);
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha Incorreta!");
			}
		}).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email não existe!"); 
		});

}

	public Optional<UsuarioModel> Logar(Optional<UsuarioLoginDTO> usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<UsuarioModel> logar(Optional<UsuarioLoginDTO> usuario) {
		// TODO Auto-generated method stub
		return null;
	}


}
