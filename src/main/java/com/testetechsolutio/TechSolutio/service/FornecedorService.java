package com.testetechsolutio.TechSolutio.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testetechsolutio.TechSolutio.model.FornecedorModel;
import com.testetechsolutio.TechSolutio.repository.FornecedorRepository;

public interface FornecedorService extends JpaRepository <FornecedorModel, Long>{

	static Object CadastrarFornecedor(@Valid FornecedorModel novofornecedor) {
		return novofornecedor;
			// TODO Auto-generated method stub
		
	}

	static @Valid Optional<FornecedorModel> CadastrarFornecedor(@Valid Optional<FornecedorModel> novofornecedor) {
		return novofornecedor;
		// TODO Auto-generated method stub
		
	}


	
}