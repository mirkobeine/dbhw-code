package de.dhbw.tinf.ddd.infrastructure.persistence.hibernate;

import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;

import de.dhbw.tinf.ddd.domain.schedule.LectureEvent;
import de.dhbw.tinf.ddd.domain.schedule.LectureEventId;
import de.dhbw.tinf.ddd.domain.schedule.LectureEventRepository;
import de.dhbw.tinf.ddd.domain.schedule.LectureTime;
import de.dhbw.tinf.ddd.domain.studentclass.StudentClass;

@Default
@RequestScoped
public class HibernateLectureEventRepository extends HibernateRepository<LectureEvent> implements LectureEventRepository {
	
	public Optional<LectureEvent> findOneByStudentClassAndLectureTime(
			StudentClass studentClass, LectureTime lectureTime) {
		// TODO Auto-generated method stub
		return null;
	}

	public LectureEvent findById(LectureEventId id) {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(LectureEvent.class, id);
	}

	public List<LectureEvent> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<LectureEvent> findAllWithin(Period period) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void store(LectureEvent lectureEvent) {
		persist(lectureEvent);
	}

	public LectureEventId nextLectureEventId() {
	    final String random = UUID.randomUUID().toString().toUpperCase();
	    return new LectureEventId(
	      random.substring(0, random.indexOf("-"))
	    );
	}

}
