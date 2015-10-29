package de.dhbw.tinf.ddd.domain.studentclass;

public final class StudentClassId {

	private String id;

	public StudentClassId(String id) {
		super();
		this.id = id;
	}

	/**
	 * needed by Hibernate/JPA
	 */
	public StudentClassId() {
		super();
	}

	@Override
	public String toString() {
		return this.id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		StudentClassId other = (StudentClassId) o;

		return sameValueAs(other);
	}

	public boolean sameValueAs(StudentClassId other) {
		return other != null && this.id.equals(other.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
