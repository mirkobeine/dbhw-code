package de.dhbw.tinf.ddd.infrastructure.persistence;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time> {

	@Override
	public Time convertToDatabaseColumn(LocalTime time) {
		return Time.valueOf(time);
	}

	@Override
	public LocalTime convertToEntityAttribute(Time dbTime) {
		return dbTime.toLocalTime();
	}
}