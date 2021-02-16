package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexao.Conexao;
import constantes.Constantes;
import model.Contato;

public class ContatoDAO {
	
	public Conexao con = null;
	
	public static ContatoDAO instance = null;
	
	public static ContatoDAO getInstance() {
		if(instance == null) {
			instance = new ContatoDAO();
		}
		return instance;
	}
	
	public boolean dropTable() {
		
		String sql;
		con = Conexao.getInstance();
		Connection dataSource = con.getConexao();

		try {
			sql = "DROP TABLE contato";
			PreparedStatement pstm = dataSource.prepareStatement(sql);
			pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, Constantes.TABLE_CONTATO_INEXIST);

		}
		
		return false;
	}

	public boolean createTable() {
		String sql;
		con = Conexao.getInstance();
		Connection dataSource = con.getConexao();

		sql  = "CREATE TABLE " 			  + Constantes.TABLE_NAME_CONTATO + "(";
		sql += Constantes.COLUMN_NOME 	  + " VARCHAR(50) NOT NULL PRIMARY KEY, ";
		sql += Constantes.COLUMN_TELEFONE + " VARCHAR(11) PRIMARY KEY, ";
		sql += Constantes.COLUMN_USUARIO  + " int (10) NOT NULL FOREIGN KEY REFERENCES " + Constantes.TABLE_NAME_USUARIO + "(" + Constantes.COLUMN_LOGIN  + ")" + ");";
		
		try {
			PreparedStatement pstm = dataSource.prepareStatement(sql);
			if (pstm.executeUpdate() == 0) {
				JOptionPane.showMessageDialog(null, Constantes.TABLE_CREATE);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void salvarPessoa(Contato contato, int usuario) throws Exception{
	
		if(!consultaPorParamento(contato.getNome(), contato.getTelefone(), contato.getUsuario()).isEmpty()) {
			throw new Exception(Constantes.ERROR_CONTATO_EXIST);
		}
		
		String sql = "insert into contato (nome, telefone, user) values (?, ?, ?)";
		PreparedStatement pstm = con.getConexao().prepareStatement(sql);
		pstm.setString(1, contato.getNome());
		pstm.setString(2, contato.getTelefone());
		pstm.setInt(3, contato.getUsuario());
		pstm.executeUpdate();
		
}

	private String consultaPorParametro(String nome_telefone) {
		
		return null;
	}
	
	private String consultaPorParametro(String nome, String telefone) {
		
		return null;
	}
	
	private ArrayList<Contato> consultaPorParamento(String nome, String telefone, int usuario) throws SQLException {
		ArrayList<Contato> listaContatos = new ArrayList<Contato>();

		
		String sql = "SELECT * FROM " + Constantes.TABLE_NAME_CONTATO + " ";
			   sql+= "WHERE " + Constantes.COLUMN_NOME + " = \"" + nome + "\""	;					
			   sql+= " AND " + Constantes.COLUMN_TELEFONE + " = \"" + telefone + "\"";				
			   sql+= " AND " + Constantes.COLUMN_USUARIO + " = " + usuario + " ;";
			   
		PreparedStatement pstm = con.getConexao().prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()) {
			
			Contato c = new Contato(rs.getString(Constantes.COLUMN_NOME), rs.getString(Constantes.COLUMN_TELEFONE), rs.getInt(Constantes.COLUMN_USUARIO));

			listaContatos.add(c);
		}
		
		return listaContatos;
	}
	
}
