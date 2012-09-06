package org.ale.thot.domain;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;

import org.codehaus.jackson.JsonParseException;

public class JsonTimeslotDao implements TimeslotDao {
	
	@Autowired
	private ObjectMapper jsonMapper;
	private static List<Day> days;
	private String filePath;
	
	public JsonTimeslotDao(ObjectMapper mapper, String filePath) {
		this.filePath = filePath;
		this.jsonMapper = mapper;
	}	
	
	public List<Timeslot> GetTimeslots(String dayName) {
		loadDaysSafely();
		for(Day day : days) {
			if (day.getShortName().equals(dayName))
				return day.getTimeslots();
		}
		return null;
	}

	public List<Day> GetConferenceDays() {
		loadDaysSafely();
		return days;
	}

	private synchronized void loadDaysSafely() {
		if (days == null)
			loadDays();		
	}

	private void loadDays() {
		
		days = new ArrayList<Day>();
				
		try {			
				InputStream jsonStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
				days = jsonMapper.readValue(jsonStream, new TypeReference<List<Day>>() {});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
