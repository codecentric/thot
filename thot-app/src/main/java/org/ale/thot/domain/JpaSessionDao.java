package org.ale.thot.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("sessionDao")
@Transactional
public class JpaSessionDao implements SessionDao {

	@PersistenceContext
	private EntityManager em;
	
	public JpaSessionDao() { }
	
	// test constructor
	public JpaSessionDao(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	public List<Session> getSessionsByDate(String date) {
		Query query = em.createNamedQuery("findSessionsForDate");
		return query.setParameter("date", date).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Session> getAllSessions() {
		return em.createNamedQuery("findAllSessions").getResultList();
	}
	
	public void saveSession(Session session) {
		em.merge(session);
	}
	
}
