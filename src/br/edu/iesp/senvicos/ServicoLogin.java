package br.edu.iesp.senvicos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.iesp.banco.DAONews.DAOUser;
import br.edu.iesp.entity.User;

@WebServlet("/ServicoLogin")
public class ServicoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServicoLogin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("manchetes.jsp").forward(request, response);
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = null;
		DAOUser daoUser = new DAOUser();
		user = daoUser.validarUser(request.getParameter("login"), request.getParameter("senha"));
		if (!(user == null)) {
			
			if (request.getParameter("login").equals(user.getLogin())
					&& request.getParameter("senha").equals(user.getSenha())) {
				
				//request.getSession().invalidate();
				HttpSession session = request.getSession();
				System.out.println("login existente");
				session.setAttribute("userlogado", user);
				request.getRequestDispatcher("manchetes.jsp").forward(request, response);	
			}
			
		} else {
			
			System.out.println("login enexistente");
			boolean aviso = true;
			request.setAttribute("aviso", aviso);
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}

	}

}
