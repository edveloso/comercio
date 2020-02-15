package edu.infnet.comercio.negocio.dao;

import java.util.List;

import javax.persistence.EntityManager;

import edu.infnet.comercio.negocio.JpaConnection;

public class JpaDAO<T, ID> {

	protected EntityManager em;
	protected Class<T> clazz;

	public JpaDAO(Class<T> clazz) {
		this.clazz = clazz;
		this.em = JpaConnection.getEmf().createEntityManager();
	}

	public List<T> findAll() {
		return this.em.createQuery("from " + clazz.getName() , clazz).getResultList();
	}

	public T find(ID id) {
		return (T) this.em.find(clazz, id);
	}

	public Boolean delete(T entity) {
		this.em.getTransaction().begin();
		this.em.remove(entity);
		this.em.getTransaction().commit();
		return true;
	}

	public Boolean edit(T entity) {
		this.em.getTransaction().begin();
		this.em.merge(entity);
		this.em.getTransaction().commit();
		return true;
	}

	public Boolean save(T entity) {
		this.em.getTransaction().begin();
		this.em.persist(entity);
		this.em.getTransaction().commit();
		return true;
	}

}