package edu.infnet.comercio.negocio;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MysqlConection {


	private static Logger logger = LogManager.getLogger(MysqlConection.class);
	
	private static Connection con;
	
	private MysqlConection() {}
	
	public static Connection getConnection() {
		if(con == null) {
			String url = "jdbc:mysql://localhost:3306/comercio"
					+ "?useTimezone=true&serverTimezone=UTC"
					+ "&createDatabaseIfNotExist=true";
			String user = "root";
			String pass = "root00";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, pass);
				logger.info("Banco iniciou");
				return con;
			} catch (Exception e) {
				logger.error("Erro ao obter conexao", e);
				throw new RuntimeException("Erro ao obter conexao ", e);
			}
		}
		
		return con;
	}
	
}
