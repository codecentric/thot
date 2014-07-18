package org.ale.thot.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.ale.thot.dao.LocationDao;
import org.ale.thot.domain.Location;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;

public class JsonLocationDao implements LocationDao {
	
	@Autowired
	private ObjectMapper jsonMapper;
	private static List<Location> locations;
	private String filePath;

	public JsonLocationDao(ObjectMapper mapper, String filePath) {
		this.filePath = filePath;
		this.jsonMapper = mapper;
	}	
	
	public List<Location> getLocations() {
		if(locations == null) {
			try {			
				final InputStream jsonStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
				if(jsonStream != null) {
					locations = jsonMapper.readValue(jsonStream, new TypeReference<List<Location>>() {});
				}
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return locations;
	}
	
	public Location getLocation(String shortName) {
		for (Location location : getLocations()) {
			if(shortName.endsWith(location.getShortName())) {
				return location;
			}	
		}
		return null;
	}
	
}
