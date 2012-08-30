package org.ale.thot.domain;

import java.util.List;

public interface TimeslotDao {

	List<String> GetTimeslots(String day);
}
