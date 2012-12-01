package org.ale.thot.domain;

import java.util.List;

import org.ale.thot.model.TimelineEntry;

public interface CommentDao {

	public List<Comment> getCommentsBySessionId(Long sessionId);
	
	public List<TimelineEntry> getRecentComments();

	public void saveComment(Comment comment);

}