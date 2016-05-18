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
	
	public ServicoManchetes() {
		super();

	}
// Recebe request de manchetes.jsp do link selecionado
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<News>	listnews = daoNews.listarNews();
		
		int id = Integer.parseInt(request.getParameter("id"));
		for (News news : listnews) {
			if (news.getId() == id) {
	//Envia a new.jsp a noticia selecionada de acordo com o id dela				
				getServletContext().setAttribute("news", news);
				request.getRequestDispatcher("news.jsp").forward(request, response);
			}

		}

	}

//Recebe request de manchetes.jsp para adicionar manchetes 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

	}

}
