package de.dhbw.tinf.ddd.domain.schedule;

import de.dhbw.tinf.ddd.domain.lecture.Lecture;

public class LectureEvent {

	private LectureEventId id;

	private Lecture lecture;
	private LectureTime lectureTime;

	protected LectureEvent() {
	}
	
	public LectureEvent(LectureEventId lectureEventId, Lecture lecture, LectureTime lectureTime) {
		super();
		this.id = lectureEventId;

		setLecture(lecture);
		setLectureTime(lectureTime);
	}

	public LectureEventId getId() {
		return id;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public LectureTime getLectureTime() {
		return lectureTime;
	}

	protected void rescheduleTo(final LectureTime newLectureTime) {
		// evtl. setter zufügen
		this.lectureTime = newLectureTime;
	}

	private void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	private void setLectureTime(LectureTime lectureTime) {
		this.lectureTime = lectureTime;
	}
}
