package model;

public class Contato implements ICoisa {
	private int id;
	private String nome;
	private String telefone;
	private int usuario;
	
	public Contato(int id, String nome, String telefone, int usuario) {
		this.id       = id;
		this.nome     = nome;
		this.telefone = telefone;
		this.usuario  = usuario;
	}
	
	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString(){
		return "Nome: " + this.nome + ","
			   + "\nTelefones: \n" + telefone.toString();
	}
	
}
