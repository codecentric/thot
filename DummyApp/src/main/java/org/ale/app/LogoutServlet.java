package org.ale.app;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import twitter4j.Twitter;

import java.io.IOException;
public class LogoutServlet extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 4660972772634343837L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Twitter twitter = (Twitter) request.getSession().getAttribute("twitter");
		request.getSession().invalidate();
	        response.sendRedirect(request.getContextPath()+ "/");
	    }
}
