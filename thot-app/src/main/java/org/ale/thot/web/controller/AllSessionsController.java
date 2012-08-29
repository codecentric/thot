package org.ale.thot.web.controller;

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
		modelMap.put("sessionsDay1", sessionDao.getSessionsByDate("Wed"));
		modelMap.put("sessionsDay2", sessionDao.getSessionsByDate("Thu"));
		modelMap.put("sessionsDay3", sessionDao.getSessionsByDate("Fri"));
	}
}
