package org.ale.app;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ale.domain.Session;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class AleAppServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6299849355548576228L;
	private Configuration cfg;

	public AleAppServlet() {
        
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		cfg = new Configuration();
		// Specify the data source where the template files come from.
		cfg.setServletContextForTemplateLoading(config.getServletContext(), "templates");
		// Specify how templates will see the data-model. This is an advanced topic...
		// but just use this:
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Template template = cfg.getTemplate("sessions.ftl");
		
		Map<String, Object> model = new HashMap<String, Object>();
		Session s1 = new Session("Title 1", "Speaker 1", "some description ...");
		Session s2 = new Session("Title 2", "Speaker 2", "some other description ...");
		List<Session> sessions = new ArrayList<Session>();
		sessions.add(s1);
		sessions.add(s2);
		model.put("sessions", sessions);
		
		try {
			template.process(model, response.getWriter());
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		
		response.getWriter().flush();
		
	}

}
