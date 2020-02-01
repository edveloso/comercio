package edu.infnet.comercio.negocio.servico;

import java.util.Objects;

import edu.infnet.comercio.negocio.dao.UsuarioDAO;
import edu.infnet.comercio.negocio.modelo.Usuario;

public class UsuarioService {
	
	private UsuarioDAO dao;
	
	public UsuarioService() {
		dao = new UsuarioDAO();
	}
	
	public Boolean validarUsuario(String login, String senha) {
		
		Usuario usuario = dao.getByLogin(login);
		if(!Objects.isNull(usuario) && usuario.getSenha().equals(senha)) {
			return true;
		}
		
		return false;
	}

	public void save(Usuario usuario) {
		dao.save(usuario);
	}
	

}
