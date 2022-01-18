package com.testetechsolutio.TechSolutio.repository;

import java.util.Optional;
import com.testetechsolutio.TechSolutio.model.UsuarioModel;
import com.testetechsolutio.TechSolutio.repository.UsuarioRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

	public Optional<UsuarioModel> findByNomeUsuario(String nomeUsuario);
	
	public Optional<com.testetechsolutio.TechSolutio.model.UsuarioModel> findByEmailUsuario(String emailUsuario);

	



	


}

