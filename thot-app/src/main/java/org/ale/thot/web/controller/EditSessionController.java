package org.ale.thot.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.ale.thot.domain.Session;
import org.ale.thot.domain.SessionDao;
import org.ale.thot.domain.Timeslot;
import org.ale.thot.domain.TimeslotDao;
import org.ale.thot.web.validate.OpenSpaceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/editSession")
public class EditSessionController {

	@Autowired
	private SessionDao sessionDao;
	@Autowired
	private TimeslotDao timeslotDao;
	
	public EditSessionController() {
		super();
	}
	
	public EditSessionController(SessionDao sessionDao, TimeslotDao timeslotDao) {
		this();
		this.sessionDao = sessionDao;
		this.timeslotDao = timeslotDao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap, HttpServletRequest request) {

		modelMap.put("sessionDataFormData", new OpenSpaceFormData());
		modelMap.put("timeslots", timeslotDao.GetTimeslots("Fri"));

		String sessionId = request.getParameter("sessionId");
		if (sessionId != null) {
			Session session = sessionDao.getSessionById(sessionId);
			modelMap.put("session", session);
			modelMap.put("sessionDataFormData", new OpenSpaceFormData(session));
			modelMap.put("sessionId", sessionId);
		}

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSubmit(HttpServletRequest request, ModelMap modelMap,
			@ModelAttribute("sessionDataFormData") OpenSpaceFormData cmd, BindingResult result) {
		
		modelMap.put("sessionDataFormData", cmd);
		
		// do validation
		OpenSpaceValidator.validate(cmd, result);
		if ( result.hasErrors() ) {
			return new ModelAndView("editSession");
		}

		String sessionId = request.getParameter("sessionId");
		if (sessionId != null) {
			Session session = sessionDao.getSessionById(sessionId);
			session.setAuthor(cmd.getSpeaker());
			session.setTitle(cmd.getTitle());
			session.setDescription(cmd.getDescription());
			session.setSlot(cmd.getStart());
			sessionDao.saveSession(session);
		} else {
			// save the data
			Session session = new Session(cmd.getDate(), cmd.getStart(), cmd.getLocation(), cmd.getTitle(), cmd.getSpeaker(), cmd.getDescription());
			sessionDao.saveSession(session);
		}
		
		// show the updated list
		return new ModelAndView("redirect:allSessions");
	}

	@RequestMapping(value = "/timeslotsPerDay", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> GetTimeslotForDay(@RequestParam("day") String day) {

		List<Timeslot> timeslots = timeslotDao.GetTimeslots(day);
		Map<String, String> timeslotsProjected = new HashMap<String, String>();

		for (Timeslot timeslot : timeslots) {
			timeslotsProjected.put(timeslot.getStart(), timeslot.toString());
		}

		return timeslotsProjected;
	}

}
