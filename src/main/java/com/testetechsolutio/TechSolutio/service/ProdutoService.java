package com.testetechsolutio.TechSolutio.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.Exercicio.Model.ProdutoModel;

public interface ProdutoService extends JpaRepository <ProdutoModel, Long> {
	
}


