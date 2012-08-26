package org.ale.thot.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.ale.thot.domain.SessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/addSession")
public class AddSessionController {

	//@Inject
	//@Autowired
	private SessionDao sessionDao;

	public AddSessionController() {
		super();
	}
	
	public AddSessionController(SessionDao sessionDao) {
		this();
		this.sessionDao = sessionDao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(ModelMap modelMap) {
		return "addSession";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(HttpServletRequest request, ModelMap modelMap, BindingResult result) {
		//TODO read data and submit to repo
		return null;
	}

}
