package de.dhbw.tinf.ddd.domain.schedule;

import java.util.Optional;

import javax.enterprise.inject.Default;

import de.dhbw.tinf.ddd.domain.studentclass.StudentClass;

@Default
public class SchedulingService {

	private LectureEventRepository lectureEventRepository;

	public void scheduleLectureEvent(LectureEvent lectureEvent,
			LectureTime lectureTime) {
		
		if (lectureEvent == null) {
			throw new RuntimeException();
		}
		if (lectureTime == null) {
			throw new RuntimeException();
		}

		if (lectureEventExistsAtDesiredTime(lectureEvent, lectureTime)) {
			throw new RuntimeException(); // TODO change type
		}
	}

	private boolean lectureEventExistsAtDesiredTime(LectureEvent lectureEvent,
			LectureTime lectureTime) {
		StudentClass studentClass = lectureEvent.getLecture().getStudentClass();
		Optional<LectureEvent> existingEvent = this.lectureEventRepository
				.findOneByStudentClassAndLectureTime(studentClass, lectureTime);
		
		return existingEvent.isPresent(); 
	}
}
