package org.ale.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="session")
public class Session {

	@Id
	private long id;
	
	private String title;
	private String speaker;
	private String description;
	
	public Session(String title, String speaker, String description) {
		super();
		this.title = title;
		this.speaker = speaker;
		this.description = description;
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
