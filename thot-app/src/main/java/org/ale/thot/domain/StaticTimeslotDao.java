package org.ale.thot.domain;

import java.util.*;

public class StaticTimeslotDao implements TimeslotDao {
	
	private Map<String, List<String>> timeslotsPerDay;
	
	public StaticTimeslotDao() {
		timeslotsPerDay = new HashMap<String, List<String>>();
		
		List<String> wedTimeSlots = new ArrayList<String>();
		wedTimeSlots.add("15:30 - 16:15");
		wedTimeSlots.add("16:15 - 17:00");
		wedTimeSlots.add("Evening");		

		List<String> thuTimeSlots = new ArrayList<String>();
		thuTimeSlots.add("15:30 - 16:15");
		thuTimeSlots.add("16:15 - 17:00");
		thuTimeSlots.add("17:00 - 17:45");
		thuTimeSlots.add("Evening");
		
		List<String> friTimeSlots = new ArrayList<String>();
		friTimeSlots.add("15:30 - 16:15");
		friTimeSlots.add("16:15 - 17:00");
		friTimeSlots.add("17:15 - 18:00");
		friTimeSlots.add("Evening");
		
		timeslotsPerDay.put("Wed", wedTimeSlots);
		timeslotsPerDay.put("Thu", thuTimeSlots);
		timeslotsPerDay.put("Fri", friTimeSlots);
	}
	
	public List<String> GetTimeslots(String day) {
		
		return timeslotsPerDay.get(day);
	}

}
