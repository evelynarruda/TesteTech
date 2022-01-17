package com.testetechsolutio.TechSolutio.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testetechsolutio.TechSolutio.model.ProdutoModel;
import com.testetechsolutio.TechSolutio.repository.FornecedorRepository;
import com.testetechsolutio.TechSolutio.repository.ProdutoRepository;


public interface ProdutoService extends JpaRepository <ProdutoModel, Long> {



	static @Valid Optional<ProdutoModel> CadastrarProduto(@Valid Optional<ProdutoModel> novoproduto) {
		// TODO Auto-generated method stub
		return novoproduto;
		
		
	}

	static Optional<Object> CadastrarProduto(@Valid ProdutoModel novoproduto) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(ProdutoModel.save(novoproduto));
	}




	}
	



