package br.com.projetoweb.beans;

public class Usuario {
	private int id;
	private String login;
	private String senha;
	private String status;
	private int pessoa_ID;
	
	public Usuario(int id, String login, String senha, String status, int pessoa_ID) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.status = status;
		this.pessoa_ID = pessoa_ID;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPessoa_ID() {
		return pessoa_ID;
	}

	public void setPessoa_ID(int pessoa_ID) {
		this.pessoa_ID = pessoa_ID;
	}
	
	
}
