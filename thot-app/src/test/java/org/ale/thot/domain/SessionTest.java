package org.ale.thot.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class SessionTest {

	private Session session;
	private Session session2;
	private Calendar now;

	@Before
	public void setup(){
		session = new Session();
		session2 = new Session();
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
		setNow(10,0);
		assertTrue(session.isInProgress(now));
	}
	
	@Test
	public void isInProgressReturnsTrueIfNowIsEnd() {
		session.setStart("10:00");
		session.setEnd("11:00");
		setNow(11,0);
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
	
    @Test
    public void compareToReturnsZeroIfStartTimeIsBothNull() throws Exception {
        session.setStart(null);
        session2.setStart(null);
        session.setLocation(null);
        session2.setLocation(null);
        assertEquals(0, session.compareTo(session2));
    }

    @Test
    public void compareToReturnsMinusOneIfStartTimeOfOnlyOneSessionNull() throws Exception {
        session.setStart(null);
        session2.setStart("09:30");
        assertEquals(-1, session.compareTo(session2));
    }

    @Test
    public void compareToReturnsOneIfStartTimeOfSessionIsGreaterThanStartTimeOfCompared() throws Exception {
        session.setStart("10:30");
        session2.setStart("09:30");
        assertEquals(1, session.compareTo(session2));
    }
    
    @Test
    public void compareToReturnsNegativeIfStartIsEqualAndLocationIsDifferent() throws Exception {
        session.setStart(null);
        session2.setStart(null);
        session.setLocation("a");
        session2.setLocation("b");
        assertTrue(session.compareTo(session2) < 0);
    }
    
    @Test
    public void compareToReturnsPositiveIfStartIsEqualAndLocationIsDifferent() throws Exception {
        session.setStart(null);
        session2.setStart(null);
        session.setLocation("b");
        session2.setLocation("a");
        assertTrue(session.compareTo(session2) > 0);
    }
    

}
