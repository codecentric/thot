package org.ale.thot.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ale.thot.domain.Session;
import org.ale.thot.domain.SessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/allSessions")
public class AllSessionsController {

	@Autowired
	private SessionDao sessionDao;

	public AllSessionsController() {
		super();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap) {
		List<Session> wed = sessionDao.getSessionsByDate("Wed");
		modelMap.put("sessionsDay1", groupSessionsByLocationsSlots(wed));
		List<Session> thu = sessionDao.getSessionsByDate("Thu");
		modelMap.put("sessionsDay2", groupSessionsByLocationsSlots(thu));
		List<Session> fri = sessionDao.getSessionsByDate("Fri");
		modelMap.put("sessionsDay3", groupSessionsByLocationsSlots(fri));
	}
	
	public static Map<String, Map<String, Session>> groupSessionsByLocationsSlots(
			List<Session> sessions) {
		HashMap<String, Map<String, Session>> transformedSessions = new HashMap<String, Map<String, Session>>();
		for(Session session : sessions) {
			Map<String, Session> sessionOfLocation = new HashMap<String, Session>();
			sessionOfLocation.put(session.getStart(), session);
			if (transformedSessions.containsKey(session.getLocation()))
				transformedSessions.get(session.getLocation()).put(session.getStart(), session);
			else
				transformedSessions.put(session.getLocation(), sessionOfLocation);
		}
		return transformedSessions;
	}
}
