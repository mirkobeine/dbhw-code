package de.dhbw.tinf.ddd.application;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import de.dhbw.tinf.ddd.domain.lecture.Lecture;
import de.dhbw.tinf.ddd.domain.lecture.LectureRepository;
import de.dhbw.tinf.ddd.domain.studentclass.StudentClass;
import de.dhbw.tinf.ddd.domain.studentclass.StudentClassId;
import de.dhbw.tinf.ddd.domain.studentclass.StudentClassRepository;

@Default
@RequestScoped
public class LectureApplicationService {

	@Inject
	private LectureRepository lectureRepository;
	
	@Inject
	private StudentClassRepository studentClassRepository;
	
	public Lecture createLecture(String name, StudentClassId studentClassId) {
		StudentClass studentClass = this.studentClassRepository.findById(studentClassId);
		Lecture lecture = new Lecture(name, studentClass);
		return this.lectureRepository.create(lecture);
	}
}
