package de.dhbw.tinf.ddd.infrastructure.persistence;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {
	private EntityManagerFactory entityManagerFactory;

	@Produces
	public EntityManager produce() {
		return this.entityManagerFactory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager entityManager) {
		entityManager.close();
	}

	@PostConstruct
	public void initialisePersistence() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("LectureSchedule");
	}
	
	@PreDestroy
	public void closePersistence() {
		this.entityManagerFactory.close();
	}
}
