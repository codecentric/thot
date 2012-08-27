package org.ale.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		final InputStream is = ClassLoader.class.getResourceAsStream("program.xls");
		final XlsSessionReader sessionReader = new XlsSessionReader(); 
		
		model.put("sessions", sessionReader.readAllSessions(is));
		
		try {
			template.process(model, response.getWriter());
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		
		response.getWriter().flush();
		
	}

}
