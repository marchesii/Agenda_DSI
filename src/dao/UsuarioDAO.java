package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexao.Conexao;
import constantes.Constantes;
import model.Usuario;

public class UsuarioDAO {
	public Conexao con = Conexao.getInstance();;
	
	public static UsuarioDAO instance = null;
	
	public static UsuarioDAO getInstance() {
		if(instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}

	public boolean createTable() throws SQLException {
		String sql;
		Connection dataSource = con.getConexao();

		sql  = "CREATE TABLE " 			  + Constantes.TABLE_NAME_USUARIO + "(";
		sql += Constantes.COLUMN_LOGIN	  + " int(10) NOT NULL, ";
		sql += Constantes.COLUMN_SENHA 	  + " int(6) NOT NULL );";
		
		try {
			
			PreparedStatement pstm = dataSource.prepareStatement(sql);
			if (pstm.executeUpdate() == 0) {
				JOptionPane.showMessageDialog(null, Constantes.TABLE_CREATE);
				return true;
			}
		} catch (SQLException e) {
			throw new SQLException(Constantes.ERROR_TABLE_CREATE);
		}
		return false;
	}
	
	public boolean dropTable() throws SQLException {
		String sql;
		Connection dataSource = con.getConexao();

		try {
			
			sql = "DROP TABLE usuario";
			PreparedStatement pstm = dataSource.prepareStatement(sql);
			pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new SQLException(Constantes.TABLE_USUARIO_INEXIST);
		}
	}
	
	public void salvarUsuario(Usuario usuario) throws Exception{
		con = Conexao.getInstance();
	
		if(!(consultaPorParamento(usuario.getLogin(), usuario.getSenha()) == null)) {
			throw new Exception(Constantes.ERROR_USUARIO_EXIST);
		}
		
		String sql = "insert into usuario (login, senha) values (?, ?)";
		PreparedStatement pstm = con.getConexao().prepareStatement(sql);
		pstm.setInt(1, usuario.getLogin());
		pstm.setInt(2, usuario.getSenha());
		pstm.executeUpdate();
	}
	
	public boolean alterarSenha(int login, int novaSenha) throws SQLException {

		String  sql  = "UPDATE " + Constantes.TABLE_NAME_USUARIO + " ";
				sql += "SET " + Constantes.COLUMN_SENHA + " = (?) ";
				sql += "WHERE " + Constantes.COLUMN_LOGIN + " = (?) ;";

		try {
			
			PreparedStatement pstm = con.getConexao().prepareStatement(sql);
			pstm.setInt(1, novaSenha);
			pstm.setInt(2, login);
			pstm.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new SQLException(Constantes.ERROR_USUARIO_UPDATE_SENHA);
		}
	}

	public Usuario consultaPorParamento(int login, int senha) throws SQLException {
		Usuario user = null;

		String  sql  = "SELECT * FROM " + Constantes.TABLE_NAME_USUARIO + " ";
				sql += "WHERE " + Constantes.COLUMN_LOGIN + " = (?) ";
				sql += " AND " + Constantes.COLUMN_SENHA + " = (?) ;";

		try {
			
			PreparedStatement pstm = con.getConexao().prepareStatement(sql);
			pstm.setInt(1, login);
			pstm.setInt(2, senha);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				user = new Usuario(rs.getInt(Constantes.COLUMN_LOGIN), rs.getInt(Constantes.COLUMN_SENHA));
			}

		} catch (SQLException e) {
			throw new SQLException(Constantes.ERROR_USUARIO_SELECT);
		}

		return user;
	}
}
