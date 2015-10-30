package de.dhbw.tinf.ddd.domain.studentclass;

public class StudentClass {

	private StudentClassId id;
	
	/**
	 * needed by JPA
	 */
	protected StudentClass() {
		super();
	}

	public StudentClass(StudentClassId id) {
		super();
		this.id = id;
	}
	
	public StudentClassId getId() {
		return id;
	}

	public String getClassName() {
		return id.toString();
	}
}
