package com.testetechsolutio.TechSolutio.model;

public class UsuarioLogin {
	
	private long Id;

	private String nome;
	
	private String email;
	
	private String senha;
	
	private String token;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String usuario) {
		this.email = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getIdUsuario() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
