package com.testetechsolutio.TechSolutio.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.Exercicio.Model.CategoriaModel;
import com.testetechsolutio.TechSolutio.model.FornecedorModel;

public interface FornecedorService extends JpaRepository <FornecedorModel, Long>{


	
}