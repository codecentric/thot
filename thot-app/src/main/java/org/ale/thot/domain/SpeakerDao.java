package org.ale.thot.domain;

import java.util.List;

import org.ale.thot.web.domain.Speaker;

public interface SpeakerDao {

	public abstract List<Speaker> getAllSpeakers();

}