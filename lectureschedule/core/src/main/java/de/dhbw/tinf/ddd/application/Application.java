package de.dhbw.tinf.ddd.application;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.dhbw.tinf.ddd.domain.schedule.LectureEvent;
import de.dhbw.tinf.ddd.domain.schedule.LectureEventId;
import de.dhbw.tinf.ddd.domain.schedule.LectureEventRepository;
import de.dhbw.tinf.ddd.infrastructure.persistence.hibernate.HibernateLectureEventRepository;

public class Application {

	public static void main(String[] args) {
		Application application = new Application();
		application.run();
	}
	
	public void run() {
		
		EntityManagerFactory factory = null;
		
		try {
			factory = Persistence.createEntityManagerFactory("PersistenceUnit");
			
			LectureEventRepository lectureEventRepository = new HibernateLectureEventRepository();
			
			LectureEventId eventId = lectureEventRepository.nextLectureEventId();
			
			LectureEvent lectureEvent = new LectureEvent(eventId, null, null);
			
			lectureEventRepository.create(lectureEvent);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (factory != null) {
				factory.close();
			}
		}
	}
}
