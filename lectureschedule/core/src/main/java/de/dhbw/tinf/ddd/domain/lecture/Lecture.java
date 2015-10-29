package de.dhbw.tinf.ddd.domain.lecture;

import de.dhbw.tinf.ddd.domain.studentclass.StudentClass;

public class Lecture {

	/**
	 * ID is managed by ORM
	 */
	private Long id;
	
	private String name;
	private StudentClass studentClass;

	public Lecture(String name, StudentClass studentClass) {
		super();
		this.name = name;
		this.studentClass = studentClass;
	}
	
	protected Lecture() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public StudentClass getStudentClass() {
		return studentClass;
	}
}
