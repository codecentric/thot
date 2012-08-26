package org.ale.thot.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Domain object to represent data for a session.
 */
@Entity(name="session")
@NamedQueries({
	@NamedQuery(name = "findSessionsForDate", query = "from session where date=:date")
})
public class Session {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private final Date date;
	private final String startTime;
	private final String endTime;
	
	private final String title;
	private final String speaker;
	private final String description;
	
	public Session(Date date, String startTime, String endTime, String title, String speaker, String description) {
		super();
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.title = title;
		this.speaker = speaker;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}
	public Date getDate() {
		return date;
	}
	public String getStartTime() {
		return startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public String getTitle() {
		return title;
	}
	public String getSpeaker() {
		return speaker;
	}
	public String getDescription() {
		return description;
	}
	
}
