package de.dhbw.tinf.ddd.application;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import de.dhbw.tinf.ddd.domain.lecture.Lecture;
import de.dhbw.tinf.ddd.domain.lecture.LectureId;
import de.dhbw.tinf.ddd.domain.lecture.LectureRepository;
import de.dhbw.tinf.ddd.domain.schedule.LectureEvent;
import de.dhbw.tinf.ddd.domain.schedule.LectureEventId;
import de.dhbw.tinf.ddd.domain.schedule.LectureEventRepository;
import de.dhbw.tinf.ddd.domain.schedule.LectureTime;
import de.dhbw.tinf.ddd.domain.schedule.SchedulingService;

@RequestScoped
@Default
public class CalendarApplicationService {

	@Inject
	private LectureEventRepository lectureEventRepository;
	
	@Inject
	private LectureRepository lectureRepository;
	
	@Inject
	private SchedulingService schedulingService;

	public CalendarApplicationService(
			final LectureEventRepository lectureEventRepository,
			final SchedulingService schedulingService) {
		super();
		this.lectureEventRepository = lectureEventRepository;
		this.schedulingService = schedulingService;
	}

	public void rescheduleLectureEvent(final LectureEventId lectureEventId,
			final LocalDate toDay, final LocalTime shouldBeginAt, final LocalTime shouldEndAt) {

		LectureTime plannedLectureTime = new LectureTime(toDay, shouldBeginAt,
				shouldEndAt);

		LectureEvent lectureEvent = this.lectureEventRepository
				.findById(lectureEventId);

		this.schedulingService.scheduleLectureEvent(lectureEvent,
				plannedLectureTime); 
	}

	public LectureEvent scheduleLectureEvent(LectureId lectureId,
			LocalDate day, LocalTime shouldBeginAt, LocalTime shouldEndAt) {
		LectureEventId lectureEventId = this.lectureEventRepository
				.nextLectureEventId();
		Lecture lecture = this.lectureRepository.findById(lectureId);

		LectureTime lectureTime = new LectureTime(day, shouldBeginAt,
				shouldEndAt);

		LectureEvent lectureEvent = new LectureEvent(lectureEventId, lecture,
				lectureTime);

		return lectureEvent;
	}

	public void deleteLectureEvent(LectureEventId lectureEventId) {

	}

	public List<LectureEvent> findLectureEventsInPeriod(Period period) {
		return this.lectureEventRepository.findAllWithin(period);
	}
}
