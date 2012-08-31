package org.ale.thot.domain;

import java.util.*;

public class StaticTimeslotDao implements TimeslotDao {
	
	private Map<String, List<Timeslot>> timeslotsPerDay;
	
	public StaticTimeslotDao() {
		timeslotsPerDay = new HashMap<String, List<Timeslot>>();
		
		List<Timeslot> wedTimeSlots = new ArrayList<Timeslot>();
		wedTimeSlots.add(new Timeslot("15:30", "16:15"));
		wedTimeSlots.add(new Timeslot("16:15", "17:00"));
		wedTimeSlots.add(new Timeslot("Evening"));		

		List<Timeslot> thuTimeSlots = new ArrayList<Timeslot>();
		thuTimeSlots.add(new Timeslot("15:30", "16:15"));
		thuTimeSlots.add(new Timeslot("16:15", "17:00"));
		thuTimeSlots.add(new Timeslot("17:00", "17:45"));
		thuTimeSlots.add(new Timeslot("Evening"));
		
		List<Timeslot> friTimeSlots = new ArrayList<Timeslot>();
		friTimeSlots.add(new Timeslot("15:30", "16:15"));
		friTimeSlots.add(new Timeslot("16:15", "17:00"));
		friTimeSlots.add(new Timeslot("17:00", "17:45"));
		friTimeSlots.add(new Timeslot("Evening"));
		
		timeslotsPerDay.put("Wed", wedTimeSlots);
		timeslotsPerDay.put("Thu", thuTimeSlots);
		timeslotsPerDay.put("Fri", friTimeSlots);
	}
	
	public List<Timeslot> GetTimeslots(String day) {
		
		return timeslotsPerDay.get(day);
	}

}
