package org.ale.thot.web.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ale.app.XlsSessionReader;
import org.ale.thot.domain.CommentDao;
import org.ale.thot.domain.Day;
import org.ale.thot.domain.Location;
import org.ale.thot.domain.LocationDao;
import org.ale.thot.domain.Session;
import org.ale.thot.domain.SessionDao;
import org.ale.thot.domain.Timeslot;
import org.ale.thot.domain.TimeslotDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/staticSessions")
public class StaticSessionsController {

	@Autowired
	private SessionDao sessionDao;

	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap) {
		
		Set<Day> conferenceDays = new HashSet<Day>();
		List<Session>staticSessions = sessionDao.getAllStaticSessions();
		if(staticSessions.isEmpty()) {
			//try to read the session from the xlsSheet
			XlsSessionReader xlsReader = new XlsSessionReader(); 
			List<Session>sessionsFromXls = xlsReader.readAllSessions();
			for (Session session : sessionsFromXls) {
				sessionDao.saveSession(session);
			}
			staticSessions = sessionDao.getAllStaticSessions();
		}

		modelMap.put("allStaticSessions", staticSessions);
		modelMap.put("days", conferenceDays);
	}

	private void createDefaultSessionsForDay(Day day, List<Location> locations) {
		for (Location location : locations) {
			for (Timeslot timeslot : day.getTimeslots()) {
				final Session session = new Session(day.getShortName(), timeslot.getStart(), location.getShortName(), Session.EMPTY_TITLE, null, Session.EMPTY_DESCRIPTION);
				sessionDao.saveSession(session);
			}
		}

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
