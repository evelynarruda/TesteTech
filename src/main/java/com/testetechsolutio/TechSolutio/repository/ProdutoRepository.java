package com.testetechsolutio.TechSolutio.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testetechsolutio.TechSolutio.model.ProdutoModel;


public interface ProdutoRepository extends JpaRepository <ProdutoModel> {

	List<com.farmacia.Exercicio.Model.ProdutoModel> findAll();

	Object save(@Valid ProdutoModel novoProduto);

	Optional<ProdutoModel> findById(Long idProduto);

	void deleteById(Long idProduto);

}