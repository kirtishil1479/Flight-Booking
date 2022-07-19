package com.flightApp.entity;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flightid;
	private String flightname;
	private Integer flightseats;
	
	public Flight(Integer flightid, String flightname, Integer flightseats) {
		super();
		this.flightid = flightid;
		this.flightname = flightname;
		this.flightseats = flightseats;
	}
	public Integer getFlightid() {
		return flightid;
	}
	public void setFlightid(Integer flightid) {
		this.flightid = flightid;
	}
	public String getFlightname() {
		return flightname;
	}
	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}
	public Integer getFlightseats() {
		return flightseats;
	}
	public void setFlightseats(Integer flightseats) {
		this.flightseats = flightseats;
	}
	public Flight() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Flight [flightid=" + flightid + ", flightname=" + flightname + ", flightseats=" + flightseats + "]";
	}
	
	
}
