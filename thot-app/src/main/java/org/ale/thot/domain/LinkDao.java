package org.ale.thot.domain;

import java.util.List;

public interface LinkDao {

	public List<Link> getLinksBySessionId(Long sessionId);

	public void saveLink(Link link);

}