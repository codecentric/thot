package org.ale.thot.web.controller;

//import  org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ale.thot.domain.Session;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

public class AllSessionsControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shouldArrangeOneSessionByLocation() {
		
		List<Session> sessions = new ArrayList<Session>();
		sessions.add(new Session("Wed", "15:30", "orange", "title1", "toto", "description" ));
		
		Map<String, Map<String, Session>> transformedSessions = AllSessionsController.groupSessionsByLocationsSlots(sessions);
		
		Assert.notEmpty(transformedSessions);
		Assert.notEmpty(transformedSessions.get("orange"));
	}
	
	@Test
	public void shouldArrangeTwoSessionsByLocations() {
		List<Session> sessions = new ArrayList<Session>();
		sessions.add(new Session("Wed", "15:30", "orange", "title1", "toto", "description" ));
		sessions.add(new Session("Wed", "15:30", "red", "title2", "toto", "description" ));
		
		Map<String, Map<String, Session>> transformedSessions = AllSessionsController.groupSessionsByLocationsSlots(sessions);
		
		Assert.isTrue(transformedSessions.size() == 2);
		Assert.notEmpty(transformedSessions.get("red"));
		Assert.isTrue(transformedSessions.get("red").size() == 1);
	}
	
	@Test
	public void shouldArrangeSessionsInSameLocationBySlot() {
		List<Session> sessions = new ArrayList<Session>();
		sessions.add(new Session("Wed", "15:30", "red", "title1", "toto", "description" ));
		sessions.add(new Session("Wed", "16:15", "red", "title2", "toto", "description" ));
		
		Map<String, Map<String, Session>> transformedSessions = AllSessionsController.groupSessionsByLocationsSlots(sessions);
		
		Assert.isTrue(transformedSessions.size() == 1);
		Assert.isTrue(transformedSessions.get("red").size() == 2);
	}
	
}
