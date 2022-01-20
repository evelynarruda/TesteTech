package com.testetechsolutio.TechSolutio.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.testetechsolutio.TechSolutio.model.UsuarioModel;
import com.testetechsolutio.TechSolutio.model.dtos.CredenciaisDTO;
import com.testetechsolutio.TechSolutio.model.dtos.UsuarioLoginDTO;
import com.testetechsolutio.TechSolutio.repository.UsuarioRepository;
import com.testetechsolutio.TechSolutio.service.UsuarioService;
	
@RestController
@RequestMapping(value = "/api/v1/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repositorio;
	
	@Autowired
	private UsuarioService usuarioService;

	
	 
	@PostMapping("/cadastrar")
    public ResponseEntity<UsuarioModel> Post(@RequestBody UsuarioModel usuario){
        return usuarioService.cadastrarUsuario(usuario)
                .map(usuarioExistente -> ResponseEntity.status(201).body(usuario))
                .orElseThrow(() ->{
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                            "Usuario existente, cadastre outro usuário!");
                });
    }
	
	@GetMapping("/todes")
	public ResponseEntity<List<UsuarioModel>> pegarTodes() {
		List<UsuarioModel> objetoLista = repositorio.findAll();

		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}

	@GetMapping("/{id_usuario}")
	public ResponseEntity<UsuarioModel> buscarPorId(@PathVariable(value = "id_usuario") Long idUsuario) {
		return repositorio.findById(idUsuario).map(resp -> ResponseEntity.status(200).body(resp))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND,
							"ID inexistente, passe um ID valido para pesquisa!.");
				});

	}

	@PostMapping("/salvar")
	public ResponseEntity<Object> salvar(@Valid @RequestBody UsuarioModel novoUsuario) {
		return usuarioService.cadastrarUsuario(novoUsuario).map(resp -> ResponseEntity.status(201).body(resp))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Email existente, cadastre outro email!.");
				});

	}
	
	
	@PutMapping("/credenciais")
	public ResponseEntity<CredenciaisDTO> credenciais(@Valid @RequestBody UsuarioLoginDTO usuarioParaAutenticar) {
		return usuarioService.pegarCredenciais(usuarioParaAutenticar);
	}

	@PutMapping("/atualizar")
	public ResponseEntity<UsuarioModel> atualizar(@Valid @RequestBody UsuarioModel novoUsuario) {
		return usuarioService.atualizarUsuario(novoUsuario).map(resp -> ResponseEntity.status(201).body(resp))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Necessario que passe um idUsuario valido para alterar!.");
				});

	}

	
	@DeleteMapping("/deletar/{id_usuario}")
	public ResponseEntity<Object> deletar(@PathVariable(value = "id_usuario") Long idUsuario) {
		return repositorio.findById(idUsuario).map(resp -> {
			repositorio.deleteById(idUsuario);
			return ResponseEntity.status(200).build();
		}).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"ID inexistente, passe um ID valido para deletar!.");
		});
	}
	
}
	
	