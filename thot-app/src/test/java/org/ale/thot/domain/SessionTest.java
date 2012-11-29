package org.ale.thot.domain;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class SessionTest {

	private Session session;
	private Calendar now;

	@Before
	public void setup(){
		session = new Session();
	}

	private void setNow(int hour, int minute) {
		now = Calendar.getInstance();
		now.set(Calendar.HOUR_OF_DAY, hour);
		now.set(Calendar.MINUTE, minute);
	}
	
	@Test
	public void isInProgressReturnsTrueIfNowIsBetweenStartAndEnd() {
		session.setStart("10:00");
		session.setEnd("11:00");
		setNow(10,23);
		assertTrue(session.isInProgress(now));
	}
	
	@Test
	public void isInProgressReturnsTrueIfNowIsStart() {
		session.setStart("10:00");
		session.setEnd("11:00");
		setNow(10,00);
		assertTrue(session.isInProgress(now));
	}
	
	@Test
	public void isInProgressReturnsTrueIfNowIsEnd() {
		session.setStart("10:00");
		session.setEnd("11:00");
		setNow(11,00);
		assertTrue(session.isInProgress(now));
	}
	
	@Test
	public void isInProgressReturnsFalseIfNowIsNotBetweenStartAndEnd() {
		session.setStart("09:00");
		session.setEnd("10:00");
		setNow(10,23);
		assertFalse(session.isInProgress(now));
	}
	
	@Test
	public void isInProgressWithNoEndDateReturnFalse() {
		session.setStart("09:00");
		session.setEnd(null);
		setNow(10,23);
		assertFalse(session.isInProgress(now));
	}
}
