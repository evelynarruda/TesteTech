package com.testetechsolutio.TechSolutio.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.testetechsolutio.TechSolutio.model.FornecedorModel;
import com.testetechsolutio.TechSolutio.repository.FornecedorRepository;

@RestController	
@RequestMapping("/api/v1/fornecedores")
@CrossOrigin("*")
public class FornecedorController {

	private @Autowired FornecedorRepository repositorio;

	@GetMapping("/todes")
	public Object getAll() {
		if (repositorio.findAll().isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
	        return ResponseEntity.status(200).body(repositorio.findAll());
	       
		}
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Object> registerComment(@RequestBody FornecedorModel novofornecedor){
		return ResponseEntity.status(201).body(repositorio.save(novofornecedor));
		}

	

	@PostMapping("/salvar")
	public ResponseEntity<Object> salvar(@Valid @RequestBody FornecedorModel novaCategoria) {
		return ResponseEntity.status(201).body(repositorio.save(novaCategoria));
	}
	
	
	@PutMapping("/atualizar")
	public ResponseEntity<Object> atualizar(@Valid @RequestBody FornecedorModel novaCategoria) {
		return ResponseEntity.status(201).body(repositorio.save(novaCategoria));
	}
	
	@DeleteMapping("/deletar/{id_fornecedor}")
	public ResponseEntity<FornecedorModel> deletar(@PathVariable(value = "id_fornecedor") String idCategoria){
		Optional<FornecedorModel> objetoOptional = repositorio.findById(idCategoria);
		if (objetoOptional.isPresent()) {
			repositorio.deleteById(idCategoria);
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(400).build();
		}
}
}
