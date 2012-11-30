package org.ale.thot.web.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class HtmlTest {
	@Test
	public void escapeHtmlLt() throws Exception {
		assertEquals("&lt;", Html.escapeHtml("<"));
	}
	@Test
	public void escapeHtmlGt() throws Exception {
		assertEquals("&gt;", Html.escapeHtml(">"));
	}
}
