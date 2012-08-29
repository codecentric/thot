package org.ale.thot.domain;

import java.util.List;

public interface CommentDao {

	@SuppressWarnings("unchecked")
	public abstract List<Comment> getCommentsBySessionId(Long sessionId);

	public abstract void saveComment(Comment comment);

}