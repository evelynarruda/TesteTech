package com.testetechsolutio.TechSolutio.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testetechsolutio.TechSolutio.model.FornecedorModel;
import com.testetechsolutio.TechSolutio.model.ProdutoModel;


public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>  {

	public Optional<ProdutoModel> findByNomeProduto(String produto);
}