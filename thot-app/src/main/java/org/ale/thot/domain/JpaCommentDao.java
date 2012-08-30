package org.ale.thot.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("commentDao")
@Transactional
public class JpaCommentDao implements CommentDao {

	@PersistenceContext
	private EntityManager em;
	
	public JpaCommentDao() { }
	
	// test constructor
	public JpaCommentDao(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	public List<Comment> getCommentsBySessionId(Long sessionId) {
		Query query = em.createNamedQuery("findCommentForSession");
		return query.setParameter("sessionId", sessionId).getResultList();
	}
	
	public Map<String, Integer> getCommentCountForSessions() {
		Query query = em.createNamedQuery("findAllComments");
		
		@SuppressWarnings("unchecked")
		List<Comment> allComments = query.getResultList();
		
		Map<String, Integer> result = new HashMap<String, Integer>();
		for ( Comment c : allComments ) {
			final String sessionId = c.getSessionId().toString();
			if ( result.containsKey(sessionId) ) {
				int cout = result.get(sessionId);
				result.put(sessionId, cout++);
			} else {
				result.put(sessionId, 1);
			}
		}
		
		System.out.println(result);
		
		return result;
	}
	
	public void saveComment(Comment comment) {
		em.merge(comment);
	}
	
}
