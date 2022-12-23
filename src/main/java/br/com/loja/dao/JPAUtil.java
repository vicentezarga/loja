package br.com.loja.dao;

import java.io.Closeable;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 
 * @author vicen
 *
 *         Classe utilitária para controlar EntityManegerFactory e EntityManeger
 *         manualmente local.
 *
 */

public class JPAUtil implements Closeable {

	private static final String PERSISTENCE_UNIT = "default";

	private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<EntityManager>();

	private static EntityManagerFactory factory;

	public JPAUtil() {

	}

	public EntityManager getConectar() {

		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		}

		EntityManager em = threadEntityManager.get();

		if (em == null || !em.isOpen()) {
			em = factory.createEntityManager();
			JPAUtil.threadEntityManager.set(em);
		}

		return em;
	}

	@Override
	public void close() throws IOException {

		EntityManager em = threadEntityManager.get();

		if (em != null) {

			EntityTransaction tx = em.getTransaction();

			if (tx.isActive()) {
				tx.commit();
			}
			em.close();
			threadEntityManager.set(null);
		}
	}
	
	
}
