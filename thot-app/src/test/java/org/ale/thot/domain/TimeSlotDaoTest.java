package org.ale.thot.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TimeSlotDaoTest {

	@Test
	public void shouldReturnWednesdayTimeSlot() {
		TimeslotDao dao = new StaticTimeslotDao();
		
		List<Timeslot> timeslots = dao.GetTimeslots("Wed");
		
		assertEquals(timeslots.size(), 3);
	}

}
