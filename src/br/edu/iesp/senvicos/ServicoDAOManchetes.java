package br.edu.iesp.senvicos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.iesp.banco.DAONews.DAONews;
import br.edu.iesp.entity.News;

@WebServlet("/ServicoDAOManchetes")
public class ServicoDAOManchetes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAONews daoNews = new DAONews();

	public ServicoDAOManchetes() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {

	}

	// recebe o id da manchete da manchete.jsp
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idNews = Integer.parseInt(request.getParameter("news"));
		ArrayList<News> listnews = daoNews.listarNews();
		// Deleta a notica de acorto com o id
		for (News news : listnews) {
			if (news.getId() == idNews) {
				daoNews.excluirNews(news);
				request.getRequestDispatcher("manchetes.jsp").forward(request, response);
			} 
		}

	}

	// recebe os parametros da manchete.jsp
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// adiciona uma noticia
		News news = new News();
		news.setManchete(request.getParameter("manchete"));
		news.setResumo(request.getParameter("resumo"));
		news.setNoticia(request.getParameter("noticia"));
		daoNews.inserirNews(news);
		request.getRequestDispatcher("manchetes.jsp").forward(request, response);

	}

}
