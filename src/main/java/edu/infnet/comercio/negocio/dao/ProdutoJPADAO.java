package edu.infnet.comercio.negocio.dao;

import java.util.List;

import javax.persistence.EntityManager;

import edu.infnet.comercio.negocio.JpaConnection;
import edu.infnet.comercio.negocio.modelo.Produto;

public class ProdutoJPADAO {

	private EntityManager em;
	
	public ProdutoJPADAO() {
		this.em = JpaConnection.getEmf().createEntityManager();
	}
	
	public List<Produto> findAll(){
		return this.em.createQuery("select p from Produto p").getResultList();
	}
	
	public Produto find(Integer id) {
		return this.em.find(Produto.class, id);
	}
	
	public Boolean delete(Produto produto) {
		this.em.getTransaction().begin();
		this.em.remove(produto);
		this.em.getTransaction().commit();
		return true;
	}
	
	public Boolean edit(Produto produto) {
		this.em.getTransaction().begin();
		this.em.merge(produto);
		this.em.getTransaction().commit();
		return true;
	}
	
	public Boolean save(Produto produto){
		this.em.getTransaction().begin();
		this.em.persist(produto);
		this.em.getTransaction().commit();
		return true;
	}
	
	
	
}
