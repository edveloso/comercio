package edu.infnet.comercio.negocio.dao;

import java.sql.Connection;
import java.util.List;

import edu.infnet.comercio.negocio.MysqlConnection;
import edu.infnet.comercio.negocio.model.Produto;

public class ProdutoDAO {
	
	private Connection con;
	
	public ProdutoDAO() {
		this.con = MysqlConnection.getConnection();
	}
	
	public List<Produto> findAllProduto(){
		
		
		
		return null;
	}
	
	

}
