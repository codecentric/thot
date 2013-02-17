package org.ale.thot.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.ale.thot.domain.SpeakerDao;
import org.ale.thot.model.CommentFormData;
import org.ale.thot.model.SpeakerFormData;
import org.ale.thot.web.domain.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/speaker")
public class AddSpeakerController {

	@Autowired
	private SpeakerDao speakerDao;

	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap, HttpServletRequest request) {
		String id = request.getParameter("id");
		SpeakerFormData speakerFormData = new SpeakerFormData();
		if (id != null) {
			Speaker speaker = speakerDao.findById(new Long(id));
			speakerFormData = new SpeakerFormData(speaker);
		}
//		modelMap.put("useMail", new Boolean(true));
		modelMap.put("speakerFormData", speakerFormData);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSubmit(final HttpServletRequest request,
			ModelMap modelMap,
			final @ModelAttribute("speakerFormData") SpeakerFormData smd,
			BindingResult result) {

		speakerDao.createOrUpdate(smd.toSpeaker());
		return new ModelAndView(new RedirectView("speakers"));
	}

}
