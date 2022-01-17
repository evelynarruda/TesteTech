package com.testetechsolutio.TechSolutio.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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

import com.testetechsolutio.TechSolutio.repository.FornecedorRepository;
import com.testetechsolutio.TechSolutio.repository.ProdutoRepository;
import com.testetechsolutio.TechSolutio.service.ProdutoService;
import com.testetechsolutio.TechSolutio.model.ProdutoModel;
import com.testetechsolutio.TechSolutio.model.UsuarioModel;

@RestController
@RequestMapping("/api/v1/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*") 
public class ProdutoController {

	@Autowired
	private ProdutoRepository repositorio;
	
	/*
	@GetMapping("/todes")
	public Object GetAll() {
		if (repositorio.findAll().isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(repositorio.findAll());
		}
	}*/
	
	@PostMapping("/register")
	public ResponseEntity<Object> registerComment(@RequestBody ProdutoModel novoproduto){
		return ResponseEntity.status(201).body(repositorio.save(novoproduto));
		}
			
				
		
	/*@PostMapping("/salvar")
	public ResponseEntity<Object> salvar(@Valid @RequestBody ProdutoModel novoProduto) {
        return ResponseEntity.status(201).body(repositorio.save(novoProduto));
   }*/
	
	@PutMapping("/atualizar")
	public ResponseEntity<Object> atualizar(@Valid @RequestBody Optional<ProdutoModel> novoProduto) {
		return ResponseEntity.status(201).body(repositorio.save(novoProduto));
	}
	
	@DeleteMapping("/deletar/{id_produto}")
	public ResponseEntity<ProdutoModel> deletar(@PathVariable(value = "id_produto") Long idProduto) {
		Optional<ProdutoModel> objetoOptional = repositorio.findById(idProduto);
		if (objetoOptional.isPresent()) {
			repositorio.deleteById(idProduto);
			return ResponseEntity.status(204).build();
		}
		else {
			return ResponseEntity.status(400).build();
		}
	}
	}
