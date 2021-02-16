/*package model;

import javax.swing.JOptionPane;

public class Agenda implements ICoisa {
	private ArrayConjunto contatos;
	
	public Agenda() {
		contatos = new ArrayConjunto();
	}

	public void adicionar(Contato contato) {
		contatos.add(contato);
	}
	
	public boolean remover(String contato) {
		boolean result = false;
		Contato c = contatoBuscaNome(contato, 0);
		if(contatos.contains(c)) {
			result = contatos.remove(c);
		}
		return result;
	}
	
	public void adicionarTelefone(String nome, String telefone) {
		Contato contato = contatoBuscaNome(nome, 0);
		if(contatos.contains(contato))
		{
			contato.setTelefone(telefone);
		}
	}
	
	public void alteraNome(String nome) {
		Contato contato;
		contato = contatoBuscaNome(nome, 0);
		if(contato != null) {
			if(contatos.contains(contato)){
				contato.setNome(JOptionPane.showInputDialog("Qual o novo nome desse contato?: "));
			}
		}
	}
	
	public void alterarTelefone(String nome, String telefone) {
		Contato contato;
		contato = contatoBuscaNome(nome, 0);
		if(contato != null) {
			if(contatos.contains(contato)) {
				contato.setTelefone(telefone);
			}
		}
	}
	
	
	public Contato contatoBuscaNome(String contato, int p) {
		Contato result = null;	
		boolean achou = false;
		
		for(p = 0; p < contatos.size() && achou == false; p++) {
			ICoisa c = contatos.get(p);
			if(c != null && contatos.obter(p).getNome().equalsIgnoreCase(contato))
			{
				result = contatos.obter(p);
				achou = true;
			}
		}
		return result;
	}

	public String contatoBuscaNome(String parametro) {
		String result = null;	
		boolean achou = false;
		
		for(int i = 0; i < contatos.size() && achou == false; i++) {
			ICoisa c = contatos.get(i);
			if(c != null && contatos.obter(i).getNome().equalsIgnoreCase(parametro))
			{
				result = c.toString();
				achou = true;
			}else {
				result = "Contato não existente";
			}
		}
		
		return result;
		
	}
	
	
	

	public ICoisa contatobusca(int posicao) {
		ICoisa result = null;
		
		if(posicao >=0 && posicao < contatos.size()) {
			result = contatos.get(posicao);
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return contatos.toString();
	}
	
	
}
*/