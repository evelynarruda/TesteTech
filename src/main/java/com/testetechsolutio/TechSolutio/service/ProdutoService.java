package com.testetechsolutio.TechSolutio.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.testetechsolutio.TechSolutio.model.ProdutoModel;
import com.testetechsolutio.TechSolutio.repository.FornecedorRepository;
import com.testetechsolutio.TechSolutio.repository.ProdutoRepository;

@Service
public class ProdutoService {

@Autowired
(required=true)
 private ProdutoRepository repository;
 
	public @Valid Optional<Object> cadastrarProduto(ProdutoModel novoproduto) {
		return repository.findByNomeProduto(novoproduto.getNomeProduto()).map(resp -> {
			return Optional.empty();
		}).orElseGet(()-> {
			return Optional.ofNullable(repository.save(novoproduto));
		});
		
	}
	
	public @Valid Optional<ProdutoModel> atualizarProduto(ProdutoModel novoproduto) {
		return repository.findById(novoproduto.getIdProduto()).map(resp -> {
			resp.setFornecedor(novoproduto.getFornecedor());
			resp.setNomeProduto(novoproduto.getNomeProduto());
			resp.setValor(novoproduto.getValor());
			return Optional.ofNullable(repository.save(resp));
		}).orElseGet(()-> {
			return Optional.empty();
		});
	
	}
}
	



