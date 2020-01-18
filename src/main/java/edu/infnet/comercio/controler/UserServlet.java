package edu.infnet.comercio.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/UserSrv"})
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha =  req.getParameter("senha");
		System.out.println(" O login foi " + login);
		System.out.println(" A senha foi " + senha);
		req.getSession().setAttribute("user", login);
		req.getRequestDispatcher("pages/home.jsp")
				.forward(req, resp);
	}
	
	
}
