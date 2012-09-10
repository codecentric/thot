package org.ale.thot.domain;

import java.util.List;

public interface TimeslotDao {

	List<Timeslot> getTimeslots(String day);

	List<Day> getConferenceDays();
}
