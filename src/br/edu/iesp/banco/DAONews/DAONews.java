package br.edu.iesp.banco.DAONews;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.edu.iesp.banco.Conexao;
import br.edu.iesp.entity.News;

public class DAONews {

	private final String SQL_INSER_NEWS = "INSERT INTO NEWS (NOTICIA,RESUMO) VALUES (?,?) ";
	private final String SQL_UPDATE_NEWS = "UPDATE NEWS SET NOTICIA = ? , RESUMO = ? WHERE ID_NEWS = ? ";
	private final String SQL_DELETE_NEWS = "DELETE FROM NEWS WHERE ID_NEWS = ?";
	private final String SQL_SELECT_NEWS = "SELECT * FROM NEWS";

	private PreparedStatement pst = null;

	public boolean inserirNews(News news) {
		boolean retorno = false;
		Connection conn = Conexao.conectar();

		try {
			pst = conn.prepareStatement(SQL_INSER_NEWS);
			pst.setString(1, news.getNoticia());
			pst.setString(2, news.getResumo());
			retorno = pst.execute();
			pst.close();
			Conexao.fecharcnx();
		} catch (SQLException e) {
			System.out.println("Erro a inserir notícia");
		}
		return retorno;

	}

	public ArrayList<News> listarNews() {

		ArrayList<News> listNews = new ArrayList<>();
		Connection conn = Conexao.conectar();
		News news;
		try {
			pst = conn.prepareStatement(SQL_SELECT_NEWS);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				news = new News();
				news.setId(rs.getInt("ID_NEWS"));
				news.setNoticia(rs.getString("NOTICIA"));
				news.setResumo(rs.getString("RESUMO"));
				listNews.add(news);

			}
			rs.close();
			pst.close();
			Conexao.fecharcnx();
		} catch (SQLException e) {
			System.out.println("Erro listar notícias");
		}

		return listNews;

	}

	public boolean alterarNews(News news) {
		boolean retorno = false;
		Connection conn = Conexao.conectar();

		try {
			pst = conn.prepareStatement(SQL_UPDATE_NEWS);
			pst.setString(1, news.getNoticia());
			pst.setString(2, news.getResumo());
			pst.setInt(3, news.getId());
			retorno = pst.execute();
			pst.close();
			Conexao.fecharcnx();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar dados");
		}
		return retorno;
	}
	
	public boolean excluirNews(News news){
		
		boolean retorno = false;
		Connection conn = Conexao.conectar();

		try {
			pst = conn.prepareStatement(SQL_DELETE_NEWS);
			pst.setInt(1, news.getId());
			retorno = pst.execute();
			pst.close();
			Conexao.fecharcnx();
		} catch (SQLException e) {
			System.out.println("Erro ao excluir");
		}
		return retorno;
	}

}
