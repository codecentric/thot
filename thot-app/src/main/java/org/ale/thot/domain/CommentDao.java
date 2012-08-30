package org.ale.thot.domain;

import java.util.List;
import java.util.Map;

public interface CommentDao {

	public List<Comment> getCommentsBySessionId(Long sessionId);
	
	public Map<String, Integer> getCommentCountForSessions();

	public void saveComment(Comment comment);

}