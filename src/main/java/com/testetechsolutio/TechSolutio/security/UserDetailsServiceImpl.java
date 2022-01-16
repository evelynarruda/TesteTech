package com.testetechsolutio.TechSolutio.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.testetechsolutio.TechSolutio.model.UsuarioLogin;
import com.testetechsolutio.TechSolutio.model.UsuarioModel;
import com.testetechsolutio.TechSolutio.repository.UsuarioRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UsuarioModel> optional = repository.findByEmailUsuario(email);
		
		if (optional.isPresent()) {
			return new UserDetailsImpl(optional.get());
		} else {
			throw new UsernameNotFoundException(email + " Não cadastrado!");
		}

}
}