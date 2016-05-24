package br.edu.iesp.senvicos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.iesp.banco.DAONews.DAOUser;
import br.edu.iesp.entity.User;

@WebServlet("/ServicoCadastroLogin")
public class ServicoCadastroLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServicoCadastroLogin() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean cadastro = true;
        request.setAttribute("cadastro", cadastro);
			request.getRequestDispatcher("login.jsp").forward(request, response);	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	DAOUser daoUser = new DAOUser();
    User user = new User();
    user.setLogin(request.getParameter("login"));
    user.setSenha(request.getParameter("senha"));
    user.setNome(request.getParameter("nome"));
    daoUser.inserirUser(user);
		
    boolean cadastrado = true;
    request.setAttribute("cadastrado", cadastrado);
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
		
	}

}
