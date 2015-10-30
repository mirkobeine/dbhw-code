package de.dhbw.tinf.ddd.infrastructure.persistence.hibernate;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;

import de.dhbw.tinf.ddd.domain.studentclass.StudentClass;
import de.dhbw.tinf.ddd.domain.studentclass.StudentClassId;
import de.dhbw.tinf.ddd.domain.studentclass.StudentClassRepository;

@Default
@RequestScoped
public class HibernateStudentClassRepository extends HibernateRepository<StudentClass>
		implements StudentClassRepository {

	@Override
	public StudentClass findById(StudentClassId id) {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(StudentClass.class, id);
	}

	@Override
	public StudentClass create(StudentClass studentClass) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(studentClass);
		entityManager.getTransaction().commit();
		return studentClass;
	}

}
