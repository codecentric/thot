package org.ale.thot.domain;

public class Timeslot {
	
	private String start;
	private String end;
	
	public Timeslot(String start, String end) {
		this(start);
		this.end = end;
	}
	
	public Timeslot(String start) {
		this.start = start;
	}

	public String getStart() {
		return start;
	}
	
	@Override
	public String toString() {
		String endToConcatenate = end != null ? " - " + end : "";
		return start + endToConcatenate;
	}
}
