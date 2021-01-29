package model;

public class Contato implements ICoisa {
	private String nome;
	private String email;
	private ArrayConjunto telefones;
	
	public Contato(String nome, String email) {
		this.nome = nome;
		this.email = email;
		telefones = new ArrayConjunto();
	}
	
	public Contato(String nome) {
		this.nome = nome;
		this.email = null;
		telefones = new ArrayConjunto();
	}
	
	
	public String getNome() {
		return this.nome;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getTelefone() {
		String result;
		result = telefones.toString();
		return result;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addTelefone(Telefone telefone) {
		telefones.add(telefone);
	}
	@Override
	public String toString(){
		return "Nome: " + this.nome + ","
			   + "\nEmail: " + this.email + ","
			   + "\nTelefones: \n" + telefones.toString();
	}
	
}
