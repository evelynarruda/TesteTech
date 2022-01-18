package com.testetechsolutio.TechSolutio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testetechsolutio.TechSolutio.model.ProdutoModel;


public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>  {

	public Optional<ProdutoModel> findByNomeProduto(String produto);
}