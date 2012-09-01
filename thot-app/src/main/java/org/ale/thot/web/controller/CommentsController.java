package org.ale.thot.web.controller;

import org.ale.app.XlsSessionReader;
import org.ale.thot.domain.CommentDao;
import org.ale.thot.domain.Session;
import org.ale.thot.domain.SessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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
		try {
			long lSessionId = Long.valueOf(sessionId);
			Session session = null;
			if (lSessionId >= XlsSessionReader.ID_OFFSET) {
				session = XlsSessionReader.getInstance().getSession(lSessionId);
			} else {
				session = sessionDao.getSessionById(sessionId);
				modelMap.put("sessionId", sessionId);
			}
			modelMap.put("comments", commentDao.getCommentsBySessionId(lSessionId));
			modelMap.put("sessionTitle", utf8(session.getTitle()));
			modelMap.put("sessionDescription", utf8(session.getDescription()));

			String location = session.getLocation() != null ? session.getLocation() : "Unknown";

			modelMap.put("sessionLocationAndTimeSlot", location + "&nbsp;&nbsp;&nbsp; at &nbsp;&nbsp;&nbsp;" +
					session
							.getStart());

			String author = session.getAuthor() != null ? session.getAuthor() : "Unknown";
			modelMap.put("sessionSpeaker", "Speaker: " + author);

		} catch (Exception e) {
			modelMap.put("comments", "");
			modelMap.put("sessionTitle", "Nice try :)");
			modelMap.put("sessionDescription", "Do you think this is something a normal user would do?");
		}
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
