package edu.infnet.comercio.negocio.dao;

import edu.infnet.comercio.negocio.modelo.Produto;

public class ProdutoJPADAO extends JpaDAO<Produto, Integer> {

	public ProdutoJPADAO() {
		super(Produto.class);
	}
	
	
	
}
