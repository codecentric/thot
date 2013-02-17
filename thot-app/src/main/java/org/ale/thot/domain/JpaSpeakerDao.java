package org.ale.thot.domain;

import java.util.ArrayList;
import java.util.List;

import org.ale.thot.web.domain.Speaker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("speakerDao")
@Transactional
public class JpaSpeakerDao implements SpeakerDao {

	/* (non-Javadoc)
	 * @see org.ale.thot.domain.SpeakerDao#getAllSpeakers()
	 */
	@Override
	public List<Speaker> getAllSpeakers() {
		List<Speaker> speakers = new ArrayList<Speaker>();
		Speaker speaker = new Speaker();
		speaker.setBio("testbio");
		speaker.setForeName("testForeName");
		speaker.setLastName("lastNametest");
		speakers.add(speaker );
		return speakers ;
	}

}
