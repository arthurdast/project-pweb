package br.edu.iesp.banco.DAONews;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.iesp.banco.Conexao;
import br.edu.iesp.entity.Comment;
import br.edu.iesp.entity.News;

public class DAOComment {

	private final String SQL_INSER_COMMENT = "INSERT INTO COMMENTS (FK_NEWS,COMENTARIO,NOME,EMAIL,DATA) VALUES (?,?,?,?,NOW)";
	private final String SQL_UPDATE_COMMENT = "UPDATE COMMENTS SET COMENTARIO = ? , NOME = ? , EMAIL = ? WHERE ID_COMMENTS = ? ";
	private final String SQL_DELETE_COMMENT = "DELETE FROM COMMENTS WHERE ID_COMMENTS = ?";
	private final String SQL_SELECT_COMMENT = "SELECT ID_COMMENTS , COMENTARIO , NOME , EMAIL , DATA FROM NEWS N INNER JOIN COMMENTS C ON N.ID_NEWS = C.FK_NEWS WHERE N.ID_NEWS = ?";

	private PreparedStatement pst = null;

	public boolean inserirComments(Comment comment) {
		boolean retorno = false;
		Connection conn = Conexao.conectar();

		try {
			pst = conn.prepareStatement(SQL_INSER_COMMENT);
			pst.setInt(1, comment.getFk_news());
			pst.setString(2, comment.getComentario());
			pst.setString(3, comment.getNome());
			pst.setString(4, comment.getEmail());
			retorno = pst.execute();
			pst.close();
			Conexao.fecharcnx();
		} catch (SQLException e) {
			System.out.println("Erro a inserir comentario");
		}
		return retorno;

	}

	public ArrayList<Comment> listarComments(News news) {

		ArrayList<Comment> listComments = new ArrayList<>();
		Connection conn = Conexao.conectar();
		Comment comment;
		try {
			pst = conn.prepareStatement(SQL_SELECT_COMMENT);
			pst.setInt(1, news.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				comment = new Comment();
				comment.setId(rs.getInt("ID_COMMENTS"));
				comment.setComentario(rs.getString("COMENTARIO"));
				comment.setNome(rs.getString("NOME"));
				comment.setEmail(rs.getString("EMAIL"));
				comment.setFk_news(news.getId());
				comment.setData(rs.getTimestamp("DATA"));
				listComments.add(comment);
			}
			rs.close();
			pst.close();
			Conexao.fecharcnx();
		} catch (SQLException e) {
			System.out.println("Erro listar comentarios");
		}

		return listComments;

	}

	public boolean alteraComment(Comment comment) {
		boolean retorno = false;
		Connection conn = Conexao.conectar();

		try {
			pst = conn.prepareStatement(SQL_UPDATE_COMMENT);
			pst.setString(1, comment.getComentario());
			pst.setString(2, comment.getNome());
			pst.setString(3, comment.getEmail());
			pst.setInt(4, comment.getId());
			retorno = pst.execute();
			pst.close();
			Conexao.fecharcnx();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar dados do comentario");
		}
		return retorno;
	}

	public boolean excluirComment(Comment comment) {

		boolean retorno = false;
		Connection conn = Conexao.conectar();

		try {
			pst = conn.prepareStatement(SQL_DELETE_COMMENT);
			pst.setInt(1, comment.getId());
			retorno = pst.execute();
			pst.close();
			Conexao.fecharcnx();
		} catch (SQLException e) {
			System.out.println("Erro ao excluir comentario");
		}
		return retorno;
	}

}
