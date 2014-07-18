package org.ale.thot.web.controller;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.ale.thot.dao.SessionDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EditSessionControllerTest {

	@Mock
	private SessionDao sessionDao;
	private EditSessionController controller;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new EditSessionController(sessionDao, new StaticTimeslotDao());
	}
	
	@Test
	public void shouldGetTimeslotListFromDay() {
		Map<String, String> timeslots = controller.GetTimeslotForDay("Wed");
		assertEquals(3, timeslots.size());		
	}

}
