package org.ale.thot.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeslotBehavior {

	@Test
	public void shouldFormatStringForTimeslotWithStartAndEnd() {
		Timeslot timeslot = new Timeslot("15:30", "16:15");
		
		String formatedTimeslot = timeslot.toString();
		
		assertEquals("15:30 - 16:15", formatedTimeslot);
	}
	
	@Test
	public void shouldFormatStringForTimeslotWithOnlyStart() {
		Timeslot timeslot = new Timeslot("15:30");
		
		String formatedTimeslot = timeslot.toString();
		
		assertEquals("15:30", formatedTimeslot);
	}

}
