package com.testetechsolutio.TechSolutio.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.Exercicio.Model.CategoriaModel;
import com.testetechsolutio.TechSolutio.model.FornecedorModel;

public interface FornecedorRepository extends JpaRepository <FornecedorModel, String>{

	Object saveAll(@Valid FornecedorModel novaCategoria);

	Object save(@Valid CategoriaModel novoCategoria);


	
}