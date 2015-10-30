package de.dhbw.tinf.ddd.infrastructure.persistence.hibernate;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public abstract class HibernateRepository<T> {

	@Inject EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	protected void persist(T entity) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(entity);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}
}
