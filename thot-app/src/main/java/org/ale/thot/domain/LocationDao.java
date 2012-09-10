package org.ale.thot.domain;

import java.util.List;

public interface LocationDao {

	List<Location> getLocations();

	Location getLocation(String shortName);

}
