package org.ale.thot.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.ale.thot.domain.Comment;
import org.ale.thot.domain.CommentDao;
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
	public CommentsController() {
		super();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap, HttpServletRequest request) {
		String sessionId = request.getParameter("sessionId"); 
		String sessionTitle = request.getParameter("title"); 
		try {
			sessionTitle = URLDecoder.decode(sessionTitle, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelMap.put("comments", commentDao.getCommentsBySessionId(Long.valueOf(sessionId)));
        modelMap.put("sessionTitle", sessionTitle);
	}
   
}
