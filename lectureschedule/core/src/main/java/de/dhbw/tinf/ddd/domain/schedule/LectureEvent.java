package de.dhbw.tinf.ddd.domain.schedule;

import de.dhbw.tinf.ddd.domain.lecture.Lecture;

public class LectureEvent {

	private LectureEventId lectureEventId;

	private Lecture lecture;
	private LectureTime lectureTime;

	public LectureEvent(LectureEventId lectureEventId, Lecture lecture, LectureTime lectureTime) {
		super();
		this.lectureEventId = lectureEventId;

		setLecture(lecture);
		setLectureTime(lectureTime);
	}

	protected LectureEvent() {
	}

	public LectureEventId getLectureEventId() {
		return lectureEventId;
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
