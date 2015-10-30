package de.dhbw.tinf.ddd.infrastructure.persistence.hibernate;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;

import de.dhbw.tinf.ddd.domain.lecture.Lecture;
import de.dhbw.tinf.ddd.domain.lecture.LectureRepository;

@Default
@RequestScoped
public class HibernateLectureRepository extends HibernateRepository<Lecture> implements LectureRepository {

	@Override
	public Lecture findById(Long id) {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(Lecture.class, id);
	}

	@Override
	public Lecture create(Lecture lecture) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(lecture);
		entityManager.getTransaction().commit();
		return lecture;
	}

}
