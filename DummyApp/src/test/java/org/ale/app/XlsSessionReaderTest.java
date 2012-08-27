package org.ale.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.ale.domain.Session;
import org.junit.Test;

public class XlsSessionReaderTest {
	private static String TESTFILE = "./src/test/resources/program.xls";
	
	@Test
	public void testSessionCount() {
		XlsSessionReader reader = null;
		try {
			reader = new XlsSessionReader();
			final List<Session> sessions = reader.readAllSessions(new FileInputStream(TESTFILE));
			assertEquals(35, sessions.size());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testSessionDataWithNulls() {
		XlsSessionReader reader = null;
		try {
			reader = new XlsSessionReader();
			final List<Session> sessions = reader.readAllSessions(new FileInputStream(TESTFILE));
			final Session session = sessions.get(0);
			assertEquals("Registration & WELCOME COFFEE", session.getTitle());
			assertEquals(null, session.getAuthor());
			assertEquals(null, session.getDescription());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
