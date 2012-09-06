package org.ale.thot.domain;

import java.util.List;

public interface TimeslotDao {

	List<Timeslot> GetTimeslots(String day);

	List<Day> GetConferenceDays();
}
