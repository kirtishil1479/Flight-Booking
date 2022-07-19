package com.flightApp.model;

import java.util.List;

import com.flightApp.entity.Passenger;

public class TicketRequest {
	
	private Integer ticketid;
	private Integer scheduleid;
	private String userid;
	private String userPassword;
	private List<Passenger> passenger;

	public TicketRequest(Integer ticketid, Integer scheduleid, String userid, String userPassword,
			List<Passenger> passenger) {
		super();
		this.ticketid = ticketid;
		this.scheduleid = scheduleid;
		this.userid = userid;
		this.userPassword = userPassword;
		this.passenger = passenger;
	}

	public Integer getTicketid() {
		return ticketid;
	}

	public void setTicketid(Integer ticketid) {
		this.ticketid = ticketid;
	}

	public TicketRequest() {
		// TODO Auto-generated constructor stub
	}

	public Integer getScheduleid() {
		return scheduleid;
	}

	public void setScheduleid(Integer scheduleid) {
		this.scheduleid = scheduleid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	

}
