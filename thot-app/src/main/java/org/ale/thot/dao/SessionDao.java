package org.ale.thot.dao;

import java.util.List;

import org.ale.thot.domain.Session;

/**
 * DAO to handle {@link Session} related stuff.
 */
public interface SessionDao {

	List<Session> getAllSessions();

	List<String> getListOfConferenceDays();
	
	List<Session> getAllStaticSessions();
	
	/* returns all sessions for a specific date */
	List<Session> getSessionsByDate(String date);
	
	void saveSession(Session session);

	Session getSessionById(String id);

	List<Session> getStaticSessionsByDate(String shortName);

	List<Session> getCurrentSessions();

}
