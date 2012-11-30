package org.ale.thot.web.controller;

import org.springframework.web.util.HtmlUtils;

public class Html {

	public static String escapeHtml(String html) {
		return HtmlUtils.htmlEscape(html);
	}
	
	public static String unEscapeHtml(String html) {
		return HtmlUtils.htmlUnescape(html);
	}
	

}
