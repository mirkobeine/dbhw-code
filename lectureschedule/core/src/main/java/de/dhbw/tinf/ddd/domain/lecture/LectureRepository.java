package de.dhbw.tinf.ddd.domain.lecture;


public interface LectureRepository {

	Lecture findById(LectureId id);
	
	Lecture create(Lecture lecture);
}
