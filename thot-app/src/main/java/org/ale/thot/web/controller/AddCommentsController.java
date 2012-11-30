package org.ale.thot.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
@RequestMapping("/addComment")
public class AddCommentsController {

	private static final String THOT_USERNAME = "THOT_username";
	
	@Autowired
	private CommentDao commentDao; 
	public AddCommentsController() {
		super();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		//String sessionId = request.getParameter("sessionId"); 
		String sessionTitle = request.getParameter("title"); 
		try {
			sessionTitle = URLDecoder.decode(sessionTitle, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CommentFormData commentFormData = new CommentFormData();
		if ( session.getAttribute(THOT_USERNAME) != null ) {
			commentFormData.setAuthor((String) session.getAttribute(THOT_USERNAME));
		}

        modelMap.put("commentFormData", commentFormData);
        modelMap.put("sessionTitle", sessionTitle);
	}
   
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSubmit(final HttpServletRequest request, ModelMap modelMap,final
			@ModelAttribute("commentFormData") CommentFormData cmd, BindingResult result) {
		
		
		
		String author = cmd.getAuthor();
		request.getSession().setAttribute(THOT_USERNAME, author);
		
		Comment comment = new Comment(new Date(), Html.escapeHtml(author), Html.escapeHtml(cmd.getText()),  Long.valueOf(cmd.getSessionId()) );
		commentDao.saveComment(comment);
		return new ModelAndView(new RedirectView("comments"){{
			this.getAttributesMap().put("sessionId", cmd.getSessionId());
			this.getAttributesMap().put("title", request.getParameter("title"));
		}});
	}
	
}
