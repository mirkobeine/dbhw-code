package de.dhbw.tinf.ddd.domain.studentclass;

public interface StudentClassRepository {

	StudentClass findById(StudentClassId id);
	
	StudentClass create(StudentClass studentClass);
}
