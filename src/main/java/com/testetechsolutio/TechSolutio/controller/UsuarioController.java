package com.testetechsolutio.TechSolutio.controller;

import java.util.List;
import java.util.Optional;

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
import com.testetechsolutio.TechSolutio.model.UsuarioLogin;
import com.testetechsolutio.TechSolutio.repository.UsuarioRepository;
	
@RestController
@RequestMapping("/api/v1/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repositorio;
	
	@Autowired
	private com.testetechsolutio.TechSolutio.service.UsuarioService usuarioService;

	@GetMapping("/todes")
	public ResponseEntity<List<UsuarioModel>> getAll() {
		List<UsuarioModel> objetoLista = repositorio.findAll();

		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}

	@GetMapping("/{id_usuario}")
	public ResponseEntity<UsuarioModel> getById(@PathVariable(value = "id_usuario") Long idUsuario) {
		Optional<UsuarioModel> objetoOptional = repositorio.findById(idUsuario);

		if (objetoOptional.isPresent()) {
			return ResponseEntity.status(200).body(objetoOptional.get());
		} else {
			return ResponseEntity.status(204).build();
		}
	}

		
	@PutMapping("/atualizar")
	public ResponseEntity<Object> atualizar(@Valid @RequestBody UsuarioModel novoUsuario) {
		return ResponseEntity.status(201).body(repositorio.save(novoUsuario));
	}

	@DeleteMapping("/deletar/{id_usuario}")
	public ResponseEntity<UsuarioModel> deletar(@PathVariable(value = "id_usuario") Long idUsuario) {
		Optional<UsuarioModel> objetoOptional = repositorio.findById(idUsuario);
		if (objetoOptional.isPresent()) {
			repositorio.deleteById(idUsuario);
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}

	@PostMapping("/logar")
	public ResponseEntity<UsuarioModel> Authentication(@RequestBody Optional<UsuarioLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Object> salvar(@Valid @RequestBody UsuarioModel usuario) {
		return usuarioService.CadastrarUsuario(usuario).map(resp -> ResponseEntity.status(201).body(resp))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Email existente, cadastre outro email!.");
				});

	}
	
 }
