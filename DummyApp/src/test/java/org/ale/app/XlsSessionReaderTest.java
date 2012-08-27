package org.ale.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.ale.domain.Session;
import org.junit.Test;

public class XlsSessionReaderTest {

	@Test
	public void testSessionCount() {
		XlsSessionReader reader = null;
		try {
			reader = new XlsSessionReader("./src/test/resources/sessions.xls");
			List<Session> sessions = reader.readAllSessions();
		
			for (Session session : sessions) {
				System.out.println(session);
			}
			assertEquals(5, sessions.size());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

}
