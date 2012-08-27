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
	
	
	
	@Override
	public String toString() {
		return "Session [title=" + title + ", speaker=" + speaker
				+ ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((speaker == null) ? 0 : speaker.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Session other = (Session) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (speaker == null) {
			if (other.speaker != null)
				return false;
		} else if (!speaker.equals(other.speaker))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
