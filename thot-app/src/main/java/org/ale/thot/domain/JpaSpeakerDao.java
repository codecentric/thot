package org.ale.thot.domain;

import java.util.ArrayList;
import java.util.List;

import org.ale.thot.web.domain.Speaker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("speakerDao")
@Transactional
public class JpaSpeakerDao implements SpeakerDao {

	private long currentId = 0;
	private List<Speaker> speakers = new ArrayList<Speaker>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.ale.thot.domain.SpeakerDao#getAllSpeakers()
	 */
	@Override
	public List<Speaker> getAllSpeakers() {
		return speakers;
	}

	@Override
	public void createOrUpdate(Speaker speaker) {
		if (speaker.getId() == null) {
			speaker.setId(currentId);
			currentId++;
		} else {
			Speaker existingSpeaker = findById(speaker.getId());
			speakers.remove(existingSpeaker);
		}
		speakers.add(speaker);
	}

	@Override
	public Speaker findById(Long id) {
		for (Speaker speaker : speakers) {
			if (speaker.getId().equals(id)) {
				return speaker;
			}
		}
		return null;
	}

}
