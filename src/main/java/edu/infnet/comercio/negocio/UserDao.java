package edu.infnet.comercio.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDao {
	
	private static Logger LOGGER = LogManager.getLogger(UserDao.class);
	
	private PreparedStatement pstm;
	private Connection con;

	public UserDao() {
		this.con = MysqlConnection.getConnection();
		LOGGER.debug("Banco conectado");
	}
	
	public Boolean salvar(Usuario usuario) {
		try {
			LOGGER.debug("salvando usuario %s", usuario);
			pstm = con
					.prepareStatement("insert into tbl_user(id, nome, email) values (null,?,?);");
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getSenha());
			return pstm.execute();
		} catch (Exception e) {
			LOGGER.error("Obtendo conexao", e);
			return false;
		}
		
	}
	
	
	

}
