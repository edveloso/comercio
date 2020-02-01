package edu.infnet.comercio.negocio;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MysqlConnection {
	
	private static Connection con;
	
	private static Logger LOGGER = LogManager.getLogger(MysqlConnection.class);
	
	private MysqlConnection() {
	}
	
	public static Connection getConnection() {
		LOGGER.debug("entrando na conexão");
		if(con == null) {
			try {
				String url = "jdbc:mysql://localhost:3306/aula01?autoReconnect=true";
				String user = "root";
				String password = "root00";
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				LOGGER.info("Conectado");
			} catch (Exception e) {
				LOGGER.error("erro ao obter a connexao ", e);
			}
		}
		return con;
	}

}
