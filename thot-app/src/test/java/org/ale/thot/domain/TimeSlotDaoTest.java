package org.ale.thot.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.ale.thot.dao.TimeslotDao;
import org.ale.thot.dao.impl.JsonTimeslotDao;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class TimeSlotDaoTest {

	@Test
	public void wrongTimeslotNameShouldReturnEmptyList() {
		final TimeslotDao dao = getDaoInstance();
		
		final List<Timeslot> timeslots = dao.getTimeslots("Err");
		
		assertNotNull(timeslots);
		assertEquals(0, timeslots.size());
		
	}

	@Test
	public void shouldReturnWednesdayTimeSlot() {
		final TimeslotDao dao = getDaoInstance();
		
		final List<Timeslot> timeslots = dao.getTimeslots("Wed");
		
		assertEquals(3, timeslots.size());
		assertEquals("16:15", timeslots.get(1).getStart());
	}
	

	private JsonTimeslotDao getDaoInstance() {
		return new JsonTimeslotDao(new ObjectMapper(), "daysAndTimeslots.json");
	}
	
	@Test
	public void shouldGetDaysOfConference() {
		TimeslotDao dao = getDaoInstance();
		
		List<Day> days = dao.getConferenceDays();
		
		assertNotNull(days);
		assertEquals(3, days.size());
	}

}
