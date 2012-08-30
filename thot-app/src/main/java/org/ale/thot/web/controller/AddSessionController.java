package org.ale.thot.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.ale.thot.domain.Session;
import org.ale.thot.domain.SessionDao;
import org.ale.thot.web.validate.OpenSpaceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/addSession")
public class AddSessionController {

	@Autowired
	private SessionDao sessionDao;

	public AddSessionController() {
		super();
	}
	
	public AddSessionController(SessionDao sessionDao) {
		this();
		this.sessionDao = sessionDao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap) {
		modelMap.put("sessionDataFormData", new OpenSpaceFormData());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSubmit(HttpServletRequest request, ModelMap modelMap,
			@ModelAttribute("sessionDataFormData") OpenSpaceFormData cmd, BindingResult result) {
		
		modelMap.put("sessionDataFormData", cmd);
		
		// do validation
		OpenSpaceValidator.validate(cmd, result);
		if ( result.hasErrors() ) {
			return new ModelAndView("addSession");
		}
		
		// save the data
		Session session = new Session(cmd.getDate(), cmd.getStart(), cmd.getLocation(), cmd.getTitle(), cmd.getSpeaker(), cmd.getDescription());
		sessionDao.saveSession(session);
		
		// show the updated list
		return new ModelAndView("redirect:allSessions");
	}

}
