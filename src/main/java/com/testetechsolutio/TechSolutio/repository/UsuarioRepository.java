package com.testetechsolutio.TechSolutio.repository;

import java.util.Optional;

import javax.validation.Valid;

import com.testetechsolutio.TechSolutio.model.UsuarioLogin;
import com.testetechsolutio.TechSolutio.model.UsuarioModel;
import com.testetechsolutio.TechSolutio.repository.UsuarioRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	
	public Optional<UsuarioModel> findByEmailUsuario(String emailUsuario);

	public Object save(@Valid UsuarioLogin usuario);

	



	


}

