package com.testetechsolutio.TechSolutio.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.testetechsolutio.TechSolutio.model.UsuarioLogin;
import com.testetechsolutio.TechSolutio.model.UsuarioModel;



public class UserDetailsImpl implements UserDetails {
	
	/**
	 * 
	 */

	
	private static final long serialVersionUID = 1L;
	private String email;
	private String senha;
	private List<GrantedAuthority> autorizacoes;
	
	public void UserDetailsImplements(UsuarioModel usuario) {
		this.email = usuario.getEmailUsuario();
		this.senha = usuario.getSenhaUsuario();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return autorizacoes;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}