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

@WebServlet("/ServicoNews")
public class ServicoNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<News> listnews;

	public ServicoNews() {
		super();

	}
// Recebe request de manchetes.jsp do link selecionado
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		for (News news : listnews) {
			if (news.getId() == id) {
	//Envia a new.jsp a noticia selecionada de acordo com o id dela				
				request.setAttribute("news", news);
				request.getRequestDispatcher("news.jsp").forward(request, response);
			}

		}

	}

//Recebe request de index.jsp do login 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAONews daoNews = new DAONews();
		listnews = daoNews.listarNews();

		request.setAttribute("listnews", listnews);
		request.getRequestDispatcher("manchetes.jsp").forward(request, response);

	}

}
