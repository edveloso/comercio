package edu.infnet.comercio.negocio.dao;

import edu.infnet.comercio.negocio.modelo.Usuario;

public class UsuarioJPADao extends JpaDAO<Usuario, Integer> {

	public UsuarioJPADao() {
		super(Usuario.class);
	}

}
