package de.dhbw.tinf.ddd.domain.schedule;

import java.io.Serializable;

public class LectureEventId implements Serializable{

	private static final long serialVersionUID = -9008552966485348466L;
	
	private final String id;

	public LectureEventId(final String id) {
		super();
		this.id = id;
	}
	
	/**
	 * needed by Hibernate/JPA
	 */
	protected LectureEventId() {
		this(null);
	}

	public String getId() {
		return id;
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

		LectureEventId other = (LectureEventId) o;

		return sameValueAs(other);
	}

	public boolean sameValueAs(LectureEventId other) {
		return other != null && this.id.equals(other.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
