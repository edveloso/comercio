package edu.infnet.comercio.negocio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.infnet.comercio.negocio.MysqlConnection;
import edu.infnet.comercio.negocio.model.Produto;

public class ProdutoDAO {
	
	private static Logger logger = LogManager.getLogger(ProdutoDAO.class);
	
	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	public ProdutoDAO() {
		this.con = MysqlConnection.getConnection();
	}
	
	public List<Produto> findAllProduto(){
		String sql = "select nome, descricao, preco, id  from produto";
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Produto produto = new Produto(rs.getString(1), rs.getString(2), rs.getDouble(3));
				produto.setId(rs.getInt(4));
				produtos.add(produto);
				logger.debug("add produto %s", produto.getNome() );
			}
			logger.debug("qtde produtos %d", produtos.size());
			return produtos;
			
		} catch (SQLException e) {
			logger.error("Erro ", e);
			throw new RuntimeException("Erro no banco");
		}
	}
	
	

}
