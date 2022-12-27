package br.com.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.loja.negocio.model.Cliente;

public class ClienteDAO implements IClienteDAO{
	
	private EntityManager em;
	private EntityTransaction tx;

	public ClienteDAO(EntityManager em) {
		this.em = em;
	}

	@Override
	public void cadastrar(Cliente cliente) {

		tx = em.getTransaction();
		if (!tx.isActive()) {
			tx.begin();
		}
		em.persist(cliente);

	}


}
