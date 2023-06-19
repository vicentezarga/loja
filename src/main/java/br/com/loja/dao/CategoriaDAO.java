package br.com.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.loja.negocio.model.Categoria;

public class CategoriaDAO {

	private EntityManager em;

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Categoria categoria) {
		EntityTransaction tx = em.getTransaction();
		
		if(!tx.isActive()) {
			tx.begin();
		}
		
		em.persist(categoria);
	}

	public Categoria consultar(long id) {
		
		return em.find(Categoria.class, id);
		
	}
	
	public Categoria atualizar(Categoria categoria) {
		return this.em.merge(categoria);
	}

}
