package br.edu.iesp.banco.DAONews;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.edu.iesp.banco.Conexao;
import br.edu.iesp.entity.User;

public class DAOUser {

	private final String SQL_INSER_USER = "INSERT INTO USER (NOME, LOGIN , SENHA) VALUES (?,?,?)";
	private final String SQL_UPDATE_USER = "UPDATE USER SET NOME = ? , LOGIN = ? , SENHA = ? WHERE ID_USER = ? ";
	private final String SQL_DELETE_USER = "DELETE FROM USER WHERE ID_USER = ?";
	private final String SQL_SELECT_USER = "SELECT ID_USER , NOME, LOGIN , SENHA FROM USER  WHERE LOGIN = ? AND SENHA = ?";

	private PreparedStatement pst = null;

	public boolean inserirUser(User user) {
		boolean retorno = false;
		Connection conn = Conexao.conectar();

		try {
			pst = conn.prepareStatement(SQL_INSER_USER);
			pst.setString(1, user.getNome());
			pst.setString(2, user.getLogin());
			pst.setString(3, user.getSenha());
			retorno = pst.execute();
			pst.close();
			Conexao.fecharcnx();
		} catch (SQLException e) {
			System.out.println("Erro a inserir usuario");
		}
		return retorno;

	}

	public User validarUser(String login, String senha) {
		User user = null;
		try {
			Connection conn = Conexao.conectar();
			pst = conn.prepareStatement(SQL_SELECT_USER);
			pst.setString(1, login);
			pst.setString(2, senha);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("ID_USER"));
				user.setNome(rs.getString("NOME"));
				user.setLogin(rs.getString("LOGIN"));
				user.setSenha(rs.getString("SENHA"));
			}
			pst.close();
			rs.close();
			Conexao.fecharcnx();

		} catch (SQLException e) {
			System.out.println("Erro ao validar login");
		}
		return user;

	}

	public boolean alterarUser(User user) {
		boolean retorno = false;
		Connection conn = Conexao.conectar();

		try {
			pst = conn.prepareStatement(SQL_UPDATE_USER);
			pst.setString(1, user.getNome());
			pst.setString(2, user.getLogin());
			pst.setString(3, user.getSenha());
			pst.setInt(4, user.getId());
			retorno = pst.execute();
			pst.close();
			Conexao.fecharcnx();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar dados do comentario");
		}
		return retorno;
	}

	public boolean excluir(int id) {

		boolean retorno = false;
		Connection conn = Conexao.conectar();

		try {
			pst = conn.prepareStatement(SQL_DELETE_USER);
			pst.setInt(1, id);
			retorno = pst.execute();
			pst.close();
			Conexao.fecharcnx();
		} catch (SQLException e) {
			System.out.println("Erro ao excluir Usuario");
		}
		return retorno;
	}

}
