package br.edu.iesp.senvicos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.iesp.banco.DAONews.DAONews;
import br.edu.iesp.entity.News;

@WebServlet("/ServicoManchetes")
public class ServicoManchetes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAONews daoNews = new DAONews();
	ArrayList<News> listnews = daoNews.listarNews();

	public ServicoManchetes() {
		super();

	}

	// Recebe request de manchetes.jsp do link selecionado
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		for (News news : listnews) {
			if (news.getId() == id) {
				// Envia a news.jsp a noticia selecionada de acordo com o id
				// dela
				getServletContext().setAttribute("news", news);
				request.getRequestDispatcher("news.jsp").forward(request, response);
			}

		}

	}

	// Recebe request de manchetes.jsp para pesquisar manchetes
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pesquisa = request.getParameter("pesquisa");

		for (News news : listnews) {
			if (pesquisa.toLowerCase().contains(news.getManchete().toLowerCase()) ) {
				
				System.out.println(news.getManchete().toLowerCase());
				getServletContext().setAttribute("news", news);
				request.getRequestDispatcher("news.jsp").forward(request, response);
				
			}
		}
		boolean sempesquisa = true;
		request.setAttribute("sempesquisa", sempesquisa);
		request.getRequestDispatcher("manchetes.jsp").forward(request, response);

	}

}
