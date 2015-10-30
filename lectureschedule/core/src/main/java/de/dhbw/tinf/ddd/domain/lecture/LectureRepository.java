package de.dhbw.tinf.ddd.domain.lecture;


public interface LectureRepository {

	Lecture findById(Long id);
	
	Lecture create(Lecture lecture);
}
