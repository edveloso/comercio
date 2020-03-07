package edu.infnet.comercio.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.cj.util.StringUtils;

import edu.infnet.comercio.negocio.dao.UsuarioDAO;
import edu.infnet.comercio.negocio.modelo.Usuario;
import edu.infnet.comercio.negocio.servico.UsuarioService;

@WebServlet(urlPatterns = {"/UserSrv"})
public class UserServlet extends HttpServlet {

	private static Logger logger = LogManager.getLogger(UserServlet.class);
	
	private UsuarioService service;
	
	public UserServlet() {
		this.service = new UsuarioService();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		
		logger.debug("Entrnando no doPost");
		
		//TODO RECUPERAR O OBJETO DA REQUISICAO
		String login = req.getParameter("login");
		String senha =  req.getParameter("senha");
		String action =  req.getParameter("action");
		
		if("new".equals(action)) {
			//TODO VALIDAR O VALORES
			if(StringUtils.isEmptyOrWhitespaceOnly(login)) {
			}
			//TODO CONVERTER OS VALORES
			
			//TODO APLICAR VALORES AO MODELO
			Usuario usuario = new Usuario(login, senha);
			
			//TODO EXECUTAR LOGICA DE NEGOCIO
			service.save(usuario);
		}
		else {
			if(service.validarUsuario(login, senha)) {
				req.getSession().setAttribute("user", login);
			}else {
				req.setAttribute("error", "Login ou senha inválidos!");
			}
			
		}
		//TODO RESTAURAR VISÃO
		req.getRequestDispatcher("pages/home.jsp")
				.forward(req, resp);
	}
	
	
}



