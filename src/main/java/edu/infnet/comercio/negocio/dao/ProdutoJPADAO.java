package edu.infnet.comercio.negocio.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.infnet.comercio.negocio.modelo.Produto;

public class ProdutoJPADAO {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("comercio");
	private EntityManager em = emf.createEntityManager();
	
	public void save(Produto produto) {
		em.getTransaction().begin();
		 em.persist(produto);
		 em.getTransaction().commit();
	}

}
