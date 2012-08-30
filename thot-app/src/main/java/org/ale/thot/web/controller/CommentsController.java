package org.ale.thot.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.ale.thot.domain.Comment;
import org.ale.thot.domain.CommentDao;
import org.ale.thot.domain.Session;
import org.ale.thot.domain.SessionDao;
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
@RequestMapping("/comments")
public class CommentsController {

	@Autowired
	private CommentDao commentDao;
	@Autowired
	private SessionDao sessionDao;

	public CommentsController() {
		super();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap, HttpServletRequest request) {
		String sessionId = request.getParameter("sessionId"); 
		Session session = sessionDao.getSessionById(sessionId);

		modelMap.put("comments", commentDao.getCommentsBySessionId(Long.valueOf(sessionId)));
        modelMap.put("sessionTitle", utf8(session.getTitle()));
        modelMap.put("sessionDescription", utf8(session.getDescription()));
	}

	private String utf8(String text) {
		String out = text;
		try {
			out = URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();			
		}
		return out;
	}
   
}
