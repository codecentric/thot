package org.ale.thot.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.ale.app.TwitterLinkCreator;
import org.ale.thot.dao.CommentDao;
import org.ale.thot.dao.LinkDao;
import org.ale.thot.dao.SessionDao;
import org.ale.thot.domain.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/comments")
public class CommentsController {

	private static final String SESSION_TYPE_SESSION = "session";
	
	@Autowired
	private LinkDao linkDao; 

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
		try {
			long lSessionId = Long.valueOf(sessionId);
			Session session = null;
			session = sessionDao.getSessionById(sessionId);
			modelMap.put("sessionId", sessionId);

			modelMap.put("forms", commentDao.getCommentsBySessionId(lSessionId));
			modelMap.put("comments", commentDao.getCommentsBySessionId(lSessionId));
			modelMap.put("links", linkDao.getLinksBySessionId(lSessionId));
			modelMap.put("sessionTitle", utf8(session.getTitle()));
			modelMap.put("sessionDescription", utf8(session.getDescription()));
			modelMap.put("sessionEditable", getSessionIsEditable(session.getType()));

			String location = session.getLocation() != null ? session.getLocation() : "Unknown";

			modelMap.put("location", location);
			modelMap.put("timeslot", session.getStart());

			String author = session.getAuthor() != null ? session.getAuthor() : "Unknown";
			modelMap.put("sessionSpeaker", TwitterLinkCreator.process(author));

		} catch (Exception e) {
			modelMap.put("comments", "");
			modelMap.put("sessionTitle", "Nice try :)");
			modelMap.put("sessionDescription", "Do you think this is something a normal user would do?");
		}
	}

	private Boolean getSessionIsEditable(String type) {
		if(type != null && type.equalsIgnoreCase(SESSION_TYPE_SESSION)){
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	private String utf8(String text) {
		String out = text == null ? "" : text;
		try {
			out = URLDecoder.decode(out, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return out;
	}
}
