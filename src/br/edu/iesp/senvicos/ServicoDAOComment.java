package br.edu.iesp.senvicos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.iesp.banco.DAONews.DAOComment;
import br.edu.iesp.banco.DAONews.DAONews;
import br.edu.iesp.entity.Comment;
import br.edu.iesp.entity.News;

@WebServlet("/ServicoDAOComment")
public class ServicoDAOComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOComment daoComment = new DAOComment();

	public ServicoDAOComment() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idNews = Integer.parseInt(request.getParameter("idNews"));
		int idComment = Integer.parseInt(request.getParameter("idComment"));
		DAONews daoNews = new DAONews();
		ArrayList<News> listnews = daoNews.listarNews();
		for (News news : listnews) {
			if (news.getId() == idNews) {
				ArrayList<Comment> listComments = daoComment.listarComments(news);
				for (Comment comment : listComments) {
					if (comment.getId() == idComment) {
							daoComment.excluirComment(comment);
							request.getRequestDispatcher("news.jsp").forward(request, response);
							
					}
				}
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Comment comment = new Comment();
		comment.setFk_news(Integer.parseInt(request.getParameter("idNews")));
		comment.setNome(request.getParameter("nome"));
		comment.setEmail(request.getParameter("email"));
		comment.setComentario(request.getParameter("comentario"));
		System.out.println("dopost ="+comment.getFk_news()+" "+comment.getNome()+" "+comment.getEmail()+" "+comment.getComentario());

		daoComment.inserirComments(comment);
		request.getRequestDispatcher("news.jsp").forward(request, response);
	}

}
