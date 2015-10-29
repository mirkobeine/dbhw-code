package de.dhbw.tinf.ddd.domain.schedule;

import java.time.Period;
import java.util.List;
import java.util.Optional;

import de.dhbw.tinf.ddd.domain.studentclass.StudentClass;

public interface LectureEventRepository {

	Optional<LectureEvent> findOneByStudentClassAndLectureTime(StudentClass studentClass, LectureTime lectureTime);
	
	LectureEvent findById(LectureEventId id);
	
	List<LectureEvent> findAll();

	List<LectureEvent> findAllWithin(Period period);
	
	void store(LectureEvent lectureEvent);
	
	LectureEventId nextLectureEventId();
}
