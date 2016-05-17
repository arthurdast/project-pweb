package br.edu.iesp.banco.DAONews;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.iesp.banco.Conexao;
import br.edu.iesp.entity.Comments;
import br.edu.iesp.entity.News;

public class DAOComments {

	private final String SQL_INSER_NEWS = "INSERT INTO COMMENTS (FK_NEWS,COMENTARIO,NOME,EMAIL) VALUES (?,?,?,?) ";
	private final String SQL_UPDATE_NEWS = "UPDATE COMMENTS SET COMENTARIO = ? , NOME = ? , EMAIL = ? WHERE ID_COMMENTS = ? ";
	private final String SQL_DELETE_NEWS = "DELETE FROM COMMENTS WHERE ID_COMMENTS = ?";
	private final String SQL_SELECT_NEWS = "SELECT ID_COMMENTS , COMENTARIO , NOME , EMAIL FROM NEWS N INNER JOIN COMMENTS C ON N.ID_NEWS = C.FK_NEWS WHERE N.ID_NEWS = ?";

	private PreparedStatement pst = null;

	public boolean inserirComments(Comments comments) {
		boolean retorno = false;
		Connection conn = Conexao.conectar();

		try {
			pst = conn.prepareStatement(SQL_INSER_NEWS);
			pst.setInt(1, comments.getFk_news());
			pst.setString(2, comments.getComentario());
			pst.setString(3, comments.getNome());
			pst.setString(3, comments.getEmail());
			retorno = pst.execute();
			pst.close();
			Conexao.fecharcnx();
		} catch (SQLException e) {
			System.out.println("Erro a inserir comentario");
		}
		return retorno;

	}

	public ArrayList<Comments> listarComments(News news) {

		ArrayList<Comments> listComments = new ArrayList<>();
		Connection conn = Conexao.conectar();
		Comments comments;
		try {
			pst = conn.prepareStatement(SQL_SELECT_NEWS);
			pst.setInt(1, news.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				comments = new Comments();
				comments.setId(rs.getInt("ID_COMMENTS"));
				comments.setComentario(rs.getString("COMENTARIO"));
				comments.setNome(rs.getString("NOME"));
				comments.setEmail(rs.getString("EMAIL"));
				comments.setFk_news(news.getId());
				listComments.add(comments);
			}
			rs.close();
			pst.close();
			Conexao.fecharcnx();
		} catch (SQLException e) {
			System.out.println("Erro listar comentarios");
		}

		return listComments;

	}

	public boolean alterarNews(Comments comments) {
		boolean retorno = false;
		Connection conn = Conexao.conectar();

		try {
			pst = conn.prepareStatement(SQL_UPDATE_NEWS);
			pst.setString(1, comments.getComentario());
			pst.setString(2, comments.getNome());
			pst.setString(3, comments.getEmail());
			pst.setInt(4, comments.getId());
			retorno = pst.execute();
			pst.close();
			Conexao.fecharcnx();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar dados do comentario");
		}
		return retorno;
	}

	public boolean excluirNews(Comments comments) {

		boolean retorno = false;
		Connection conn = Conexao.conectar();

		try {
			pst = conn.prepareStatement(SQL_DELETE_NEWS);
			pst.setInt(1, comments.getId());
			retorno = pst.execute();
			pst.close();
			Conexao.fecharcnx();
		} catch (SQLException e) {
			System.out.println("Erro ao excluir comentario");
		}
		return retorno;
	}

}
