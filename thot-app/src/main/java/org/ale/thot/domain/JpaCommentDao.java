package org.ale.thot.domain;

import java.util.List;

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
	
	/* (non-Javadoc)
	 * @see org.ale.thot.domain.CommentDao#getCommentsBySessionId(java.lang.Long)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Comment> getCommentsBySessionId(Long sessionId) {
		Query query = em.createNamedQuery("findCommentForSession");
		return query.setParameter("sessionId", sessionId).getResultList();
	}
	
	/* (non-Javadoc)
	 * @see org.ale.thot.domain.CommentDao#saveComment(org.ale.thot.domain.Comment)
	 */
	@Override
	public void saveComment(Comment comment) {
		em.merge(comment);
	}
	
}
