package edu.infnet.comercio.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.infnet.comercio.negocio.dao.ProdutoDAO;
import edu.infnet.comercio.negocio.dao.ProdutoJPADAO;
import edu.infnet.comercio.negocio.modelo.Categoria;
import edu.infnet.comercio.negocio.modelo.Produto;

@WebServlet(urlPatterns = {"/ComprasSrv"})
public class ComprasServlet extends HttpServlet {

	private ProdutoDAO dao;
	
	private ProdutoJPADAO jpaDao;
	
	public ComprasServlet() {
		this.dao = new ProdutoDAO();
		jpaDao = new ProdutoJPADAO();
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(ComprasServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("entrando no doget");
		
		Produto produto = new Produto("prod1", "meu produto", 20.0, "");
		Categoria categoria = new Categoria();
		categoria.setNome("Cate1");
		produto.setCategoria(categoria);
		jpaDao.save(produto);
		
		List<Produto> produtos = dao.findAllProdutos();
		
		req.setAttribute("lista_produto", produtos);
		
		
		req.getRequestDispatcher("pages/catalogo.jsp")
				.forward(req, resp);
	}
		
}








