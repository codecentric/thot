package org.ale.thot.model;


import org.ale.thot.domain.Session;

public class OpenSpaceFormData {

	private Long sessionId;
	private String date;
	private String title;
	private String speaker;
	private String description;
	private String start;
	private String location;

	public OpenSpaceFormData() {
	}

	public OpenSpaceFormData(Session session) {
		this.setSessionId(session.getId());
		this.date = session.getDate();
		this.title = Html.unEscapeHtml(session.getTitle());
		this.speaker = Html.unEscapeHtml(session.getAuthor());
		this.description = Html.unEscapeHtml(session.getDescription());
		this.start = session.getStart();
		this.location = session.getLocation();
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSpeaker() {
		return speaker;
	}
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getSessionId() {
		return sessionId;
	}
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}
}
