package com.testetechsolutio.TechSolutio.controller;

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

import com.testetechsolutio.TechSolutio.repository.ProdutoRepository;
import com.testetechsolutio.TechSolutio.service.ProdutoService;
import com.testetechsolutio.TechSolutio.model.ProdutoModel;

@RestController
@RequestMapping("/api/v1/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*") 
public class ProdutoController {

	@Autowired
	private ProdutoRepository repositorio;
	@Autowired
	private ProdutoService service;
	
	
	@GetMapping("/todes")
	public Object GetAll() {
		if (repositorio.findAll().isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(repositorio.findAll());
		}
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<ProdutoModel> salvar(@RequestBody @Valid ProdutoModel novoproduto) {
		return service.cadastrarProduto(novoproduto).map(resp -> ResponseEntity.status(201).body(novoproduto))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Produto já existente");
	});

	}
				
	@PutMapping("/atualizar")
	public ResponseEntity<ProdutoModel> atualizar(@Valid @RequestBody ProdutoModel novoProduto) {
		return service.atualizarProduto(novoProduto).map(resp -> ResponseEntity.status(201).body(resp))
				.orElseThrow(() ->{
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Necessário que passe um idUsuario válido");
				});
	}
	
	@DeleteMapping("/deletar/{id_produto}")
	public ResponseEntity<Object> deletar(@PathVariable(value = "id_produto") Long idProduto) {
		return repositorio.findById(idProduto).map(resp ->{
			repositorio.deleteById(idProduto);
			return ResponseEntity.status(200).build();
		}).orElseThrow(() ->{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"ID inexistente, passe um ID valido para deletar!.");
		});
	}
}
