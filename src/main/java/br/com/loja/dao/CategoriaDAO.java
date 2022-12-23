package br.com.loja.dao;

import javax.persistence.EntityManager;

import br.com.loja.negocio.model.Categoria;

public class CategoriaDAO {

	private EntityManager em;

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Categoria categoria) {
		em.persist(categoria);
	}

	public Categoria atualizar(Categoria categoria) {
		return this.em.merge(categoria);
	}

}
