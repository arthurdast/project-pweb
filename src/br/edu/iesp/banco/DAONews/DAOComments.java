package br.edu.iesp.banco.DAONews;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.iesp.banco.Conexao;
import br.edu.iesp.entity.Comments;

public class DAOComments {

	
	private final String SQL_INSER_NEWS = "INSERT INTO COMMENTS (FK_NEWS,COMENTARIO,NOME,EMAIL) VALUES (?,?,?,?) ";
	private final String SQL_UPDATE_NEWS = "UPDATE COMMENTS SET COMENTARIO = ? , NOME = ? , EMAIL = ? WHERE ID_COMMENTS = ? ";
	private final String SQL_DELETE_NEWS = "DELETE FROM COMMENTS WHERE ID_COMMENTS = ?";
	private final String SQL_SELECT_NEWS = "SELECT ID_COMMENTS , COMENTARIO , NOME , EMAIL FROM NEWS N INNER JOIN COMMENTS C ON N.ID_NEWS = C.FK_NEWS WHERE N.ID_NEWS = ?";
	
	
	private PreparedStatement pst = null;

	public boolean inserirNews(Comments comments) {
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
	
	
}
