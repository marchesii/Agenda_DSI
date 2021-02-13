package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexao.Conexao;
import constantes.Constantes;

public class ContatoDAO {

	public boolean createTable(String tabela) {
		String sql;
		Connection dataSource = Conexao.getInstance().getConexao();

		try {
			sql = "DROP TABLE contato";
			PreparedStatement pstm = dataSource.prepareStatement(sql);
			pstm.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, Constantes.TABLE_CONTATO_INEXIST);

		}

		sql  = "CREATE TABLE " 			  + Constantes.TABLE_NAME_CONTATO + "(";
		sql += Constantes.COLUMN_ID 	  + " int(2) NOT NULL AUTO_INCREMENT PRIMARY KEY, ";
		sql += Constantes.COLUMN_NOME 	  + " VARCHAR(20) NOT NULL, ";
		sql += Constantes.COLUMN_TELEFONE + " VARCHAR(11) ";
		sql += Constantes.COLUMN_USUARIO  + "int (2) NOT NULL );";

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
	
}
