package com.flightApp.model;

public class Schedule {
	
	private Integer scheduleid;
	private String date;
	private String time;
	private Flight flight;
	private Integer availseats;
	private String status;
	
	public Integer getScheduleid() {
		return scheduleid;
	}
	public void setScheduleid(Integer scheduleid) {
		this.scheduleid = scheduleid;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getAvailseats() {
		return availseats;
	}
	public void setAvailseats(Integer availseats) {
		this.availseats = availseats;
	}

	

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Schedule() {
		// TODO Auto-generated constructor stub
	}	
	
	public Schedule(Integer scheduleid, String date, String time,  Flight flight, Integer availseats,
			Integer price, String status) {
		super();
		this.scheduleid = scheduleid;
		this.date = date;
		this.time = time;
		this.flight = flight;
		this.availseats = availseats;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Schedule [scheduleid=" + scheduleid + ", date=" + date + ", time=" + time + ", flight=" + flight
				+ ", availseats=" + availseats + "]";
	}


}
