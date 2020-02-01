package edu.infnet.comercio.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.infnet.comercio.negocio.UserDao;
import edu.infnet.comercio.negocio.Usuario;

@WebServlet(urlPatterns = {"/UserSrv"})
public class UserServlet extends HttpServlet {

	
	private static Logger LOGGER = LogManager.getLogger(UserServlet.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private UserDao dao = new UserDao();
	
	

	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		LOGGER.debug("Get doPos");
		
		String action = req.getParameter("action");
		
		String login = req.getParameter("login");
		String senha =  req.getParameter("senha");
		System.out.println(" O login foi " + login);
		System.out.println(" A senha foi " + senha);
		String pagina = "/pages/home.jsp";
		
		
		if("new".equals(action)) {
			LOGGER.info("Cadastro no banco solicitado");
			Usuario usuario = new Usuario(login, senha);
			dao.salvar(usuario); 
			LOGGER.info("Usuario salvo com sucesso %s", usuario);
			pagina = "/login.jsp";
		}
		
		req.getSession().setAttribute("user", login);
		req.getRequestDispatcher(pagina)
				.forward(req, resp);
	}
	
	
}
