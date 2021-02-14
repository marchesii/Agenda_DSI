package model;

public class Usuario {
	private int login;
	private int senha;
	
	public Usuario(int login, int senha) {
		this.login = login;
		this.senha = senha;
	}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	
	
}
