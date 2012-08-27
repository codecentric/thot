package org.ale.app;

import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = -6764470822089012080L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setCharacterEncoding("UTF-8");
	        String text = request.getParameter("text");
	        Twitter twitter = (Twitter)request.getSession().getAttribute("twitter");
	        try {
	            twitter.updateStatus(text);
	        } catch (TwitterException e) {
	            throw new ServletException(e);
	        }
	        response.sendRedirect(request.getContextPath()+ "/");
	    }
}
