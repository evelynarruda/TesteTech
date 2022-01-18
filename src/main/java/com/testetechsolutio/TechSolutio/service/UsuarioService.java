package com.testetechsolutio.TechSolutio.service;

import java.nio.charset.Charset;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.testetechsolutio.TechSolutio.model.UsuarioModel;
import com.testetechsolutio.TechSolutio.model.UsuarioLogin;
import com.testetechsolutio.TechSolutio.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	
	public Optional<Object> CadastrarUsuario(@Valid UsuarioModel usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return repository.findByEmailUsuario(usuario.getEmailUsuario()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			usuario.setSenhaUsuario(encoder.encode(usuario.getSenhaUsuario()));
			return Optional.ofNullable(repository.save(usuario));
		});

	}

	public Optional<UsuarioModel> Logar(Optional<UsuarioLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UsuarioModel> usuario = repository.findByEmailUsuario(user.get().getEmail());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenhaUsuario())) {
				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodeAuth);

				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNomeUsuario());
				user.get().setIdUsuario(usuario.get().getIdUsuario());
				user.get().setSenha(usuario.get().getSenhaUsuario());
				user.get().setEmail(usuario.get().getEmailUsuario());
				
				return usuario;
			}
		}
		return null;
	}
}
