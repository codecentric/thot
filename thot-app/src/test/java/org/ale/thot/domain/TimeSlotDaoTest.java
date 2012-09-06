package org.ale.thot.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class TimeSlotDaoTest {

	@Test
	public void shouldReturnWednesdayTimeSlot() {
		TimeslotDao dao = getDaoInstance();
		
		List<Timeslot> timeslots = dao.GetTimeslots("Wed");
		
		assertEquals(3, timeslots.size());
		assertEquals("16:15", timeslots.get(1).getStart());
	}

	private JsonTimeslotDao getDaoInstance() {
		return new JsonTimeslotDao(new ObjectMapper(), "org/ale/thot/domain/data/daysAndTimeslots.json");
	}
	
	@Test
	public void shouldGetDaysOfConference() {
		TimeslotDao dao = getDaoInstance();
		
		List<Day> days = dao.GetConferenceDays();
		
		assertNotNull(days);
		assertEquals(3, days.size());
	}

}
