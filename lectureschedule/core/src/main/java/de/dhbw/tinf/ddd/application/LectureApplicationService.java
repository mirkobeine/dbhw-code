package de.dhbw.tinf.ddd.application;

import javax.inject.Inject;

import de.dhbw.tinf.ddd.domain.lecture.Lecture;
import de.dhbw.tinf.ddd.domain.lecture.LectureRepository;
import de.dhbw.tinf.ddd.domain.studentclass.StudentClass;
import de.dhbw.tinf.ddd.domain.studentclass.StudentClassId;

public class LectureApplicationService {

	@Inject
	private LectureRepository lectureRepository;
	
	public Lecture createLecture(String name, StudentClassId studentClassId) {
		
		StudentClass studentClass = new StudentClass(studentClassId);
		Lecture lecture = new Lecture(name, studentClass);
		
		return this.lectureRepository.create(lecture);
	}
}
