package com.testetechsolutio.TechSolutio.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testetechsolutio.TechSolutio.model.FornecedorModel;
import com.testetechsolutio.TechSolutio.model.ProdutoModel;


public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>  {

	static Object CadastrarProduto(@Valid ProdutoModel novoproduto) {
		return novoproduto;
		// TODO Auto-generated method stub
		
	}

	static @Valid Optional<ProdutoModel> CadastrarProduto(@Valid Optional<ProdutoModel> novoproduto) {
		return novoproduto;
		// TODO Auto-generated method stub
		
	}

	Object save(@Valid Optional<ProdutoModel> novoProduto);

}