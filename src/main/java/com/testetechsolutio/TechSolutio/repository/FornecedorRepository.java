package com.testetechsolutio.TechSolutio.repository;

import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


import com.testetechsolutio.TechSolutio.model.FornecedorModel;
import com.testetechsolutio.TechSolutio.model.ProdutoModel;

public interface FornecedorRepository extends JpaRepository <FornecedorModel, String>{

	static Object save( @Valid ProdutoModel novoproduto) {
		return null;
	}

	static Object save(@Valid Optional<FornecedorModel> novofornecedor) {
		return null;
	}

	Object save(Comment comment);
	
}