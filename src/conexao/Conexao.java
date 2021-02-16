package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import constantes.Constantes;

public class Conexao {
	private static Conexao conexao = null;
	private static Connection dataSource = null;
	private String url = "jdbc:mysql://localhost:3306/dsi";
	private String usuario = "usuario";
	private String senha = "usuario";
	
	private Conexao() {
		
		try {			
			dataSource = DriverManager.getConnection(url, usuario, senha);
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, Constantes.ERROR_CONNECT_BANCO);
			e.printStackTrace();
		}

	}
		
	public Connection getConexao() {
		return dataSource;
	}
	
	public static Conexao getInstance() {
		
		if(conexao == null) {
			conexao =  new Conexao();
		}
		return conexao;
		
	}
}
