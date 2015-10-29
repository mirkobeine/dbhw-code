package de.dhbw.tinf.ddd.domain.schedule;

import java.time.LocalDate;
import java.time.LocalTime;

public final class LectureTime {

	private LocalDate lectureDay;
	private LocalTime beginsAt;
	private LocalTime endsAt;

	public LectureTime(LocalDate lectureDay, LocalTime beginsAt,
			LocalTime endsAt) {
		super();
		beginsBeforeItEnds(beginsAt, endsAt);
		setLectureDay(lectureDay);
		setBeginsAt(beginsAt);
		setEndsAt(endsAt);
	}

	private void beginsBeforeItEnds(LocalTime beginsAt, LocalTime endsAt) {
		if (beginsAt.isBefore(endsAt)) {
			return;
		}
		throw new IllegalArgumentException(
				String.format(
						"a lectureTime must begin before it ends,  but it begins at [%s] and ends at[%s]",
						beginsAt, endsAt));
	}

	public LocalDate getLectureDay() {
		return lectureDay;
	}

	public LocalTime getBeginsAt() {
		return beginsAt;
	}

	public LocalTime getEndsAt() {
		return endsAt;
	}

	private void setLectureDay(LocalDate lectureDay) {
		this.lectureDay = lectureDay;
	}

	private void setBeginsAt(LocalTime beginsAt) {
		this.beginsAt = beginsAt;
	}

	private void setEndsAt(LocalTime endsAt) {
		this.endsAt = endsAt;
	}
}
