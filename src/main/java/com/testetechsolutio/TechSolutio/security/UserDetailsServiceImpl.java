package com.testetechsolutio.TechSolutio.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.testetechsolutio.TechSolutio.model.UsuarioModel;
import com.testetechsolutio.TechSolutio.repository.UsuarioRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UsuarioRepository repositorio;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UsuarioModel> objetoOptional = repositorio.findByEmailUsuario(username);
		
		if (objetoOptional.isPresent()) {
			return new UserDetailsImpl();
		} else {
			throw new UsernameNotFoundException(username + " Não existe!");
		}
		
	
}
}