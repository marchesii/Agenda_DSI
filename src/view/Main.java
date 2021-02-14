package view;

import javax.swing.JOptionPane;

import dao.ContatoDAO;
import model.Agenda;

import model.Contato;
import model.ICoisa;
import model.Telefone;
  
public class Main
{  
     public static void main(String[] args) {
    	Agenda a;
        a = new Agenda();
        String nome;
  		String valor;
  		int op = 0;
  		
  		
  		do {
  			valor = JOptionPane.showInputDialog(null, "Digite uma Opção \n" +
  					"\n 1- Incluir contato" +
  					"\n 2- Remover contato" +
  					"\n 3- Consultar por nome" +
  					"\n 4- Ver todos Contatos" +
  					"\n 5- Adicionar numero ao contato" +
  					"\n 6- Alterar contato" +
  					"\n 7- Sair");
  			try {
  				if(valor == null) {
  					ContatoDAO.getInstance().createTable();
  					op = 7;
  				}else {
  					op = Integer.parseInt(valor);
  				}		
  			} catch(NumberFormatException e) {
  				op = 0;
  				JOptionPane.showMessageDialog(null, "Você digitou algo incorreto, por favor somente numeros aqui.");
  			}
  			switch(op) {
  			case 1:
  				//TODO INCLUIR ICONTATO
  			case 2:
  				nome = JOptionPane.showInputDialog("Insira o nome do contato a ser excluido: ");
  				if(nome == null)
  				{
  					JOptionPane.showMessageDialog(null, "Impossivel excluir, digite o nome do contato no campo por favor.");
  				}else {
  					if(a.remover(nome)) {
  						JOptionPane.showMessageDialog(null, "Contato excluido");
  					}else {
  						JOptionPane.showMessageDialog(null, "Nao foi possivel excluir o contato");
  					}
  				}
  				break;
  			case 3:
  				nome = JOptionPane.showInputDialog("Por favor insira o nome: ");
  				JOptionPane.showMessageDialog(null, a.contatoBuscaNome(nome));
  				break;
  			case 4:
  				mostraTudo(a);
  				break;
  			case 5:
  				nome = JOptionPane.showInputDialog("Por favor insira o nome: ");
  				String telefone = telefoneNovo();
  				a.adicionarTelefone(nome, telefone);
  				JOptionPane.showMessageDialog(null,  a.contatoBuscaNome(nome).toString());
  				break;
  			case 6:
  				nome = JOptionPane.showInputDialog("Digite o nome do contato a ser editado: ");
  				int alteracao = JOptionPane.showConfirmDialog(null, "Você quer alterar o nome?", "Agenda", JOptionPane.YES_NO_OPTION);
  					if(alteracao == 0) {
  						a.alteraNome(nome);
  						JOptionPane.showMessageDialog(null, "Contato alterado com sucesso");
  						mostraTudo(a);
  					}
  					break;
  			default:
  				break;
  			}
  		} while(op != 7);
     }
     
     public static void mostraTudo(ICoisa agenda) {
    	 JOptionPane.showMessageDialog(null, agenda.toString());
     }
     
     public static String telefoneNovo() {
    	int ddd = 0, prefixo = 0, sufixo = 0;
    	Telefone telefone = new Telefone(ddd, prefixo, sufixo);
    	String valor;
    	valor = JOptionPane.showInputDialog(null, "Qual seu ddd? \n");
	 	if(tryCatch(valor) == true) {
	 		ddd = Integer.parseInt(valor);
	 		telefone.setDdd(ddd);
	 	}else {
	 		telefone.setDdd(0);
	 	}
    	valor = JOptionPane.showInputDialog(null, "Qual seu prefixo? \n");
	 	if(tryCatch(valor) == true) {
	 		prefixo = Integer.parseInt(valor);
	 		telefone.setPrefixo(prefixo);
	 	}else {
	 		telefone.setPrefixo(0);
	 	}
		valor = JOptionPane.showInputDialog(null, "Qual seu sufixo? \n");
	 	if(tryCatch(valor) == true) {
	 		sufixo = Integer.parseInt(valor);
	 		telefone.setSufixo(sufixo);
	 	}else {
	 		telefone.setSufixo(0);
	 	}
		return telefone.toString();
     }
     
     private static boolean tryCatch(String valor) {
    	 boolean deucerto = true;
    	 int inteiro;
    	 
    	 try {
    		 inteiro = Integer.parseInt(valor);
    	 } catch(NumberFormatException e) {
    		 JOptionPane.showMessageDialog(null, "Você digitou algo incorreto, por favor digite somente numeros");
    		 deucerto = false;
    	 }
    	 
    	 return deucerto;
     }
}