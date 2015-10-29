package de.dhbw.tinf.ddd.domain.studentclass;

public class StudentClass {

	private StudentClassId id;
	
	public StudentClass(StudentClassId id) {
		super();
		this.id = id;
	}

	private String getClassName() {
		return id.toString();
	}
}
