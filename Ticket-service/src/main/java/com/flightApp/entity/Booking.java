package com.flightApp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingid;
	private String userid;
	private String flightname;
	private String source;
	private String destination;
	private String journydate;
	private String bookingdate;
	private String bookingstatus;
	
	@OneToMany(targetEntity = Passenger.class, cascade = CascadeType.ALL,mappedBy = "booking")
	private List<Passenger> passenger;

	public Integer getBookingid() {
		return bookingid;
	}

	public void setBookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFlightname() {
		return flightname;
	}

	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getJournydate() {
		return journydate;
	}

	public void setJournydate(String journydate) {
		this.journydate = journydate;
	}

	public String getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}

	public String getBookingstatus() {
		return bookingstatus;
	}

	public void setBookingstatus(String bookingstatus) {
		this.bookingstatus = bookingstatus;
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

	public Booking(Integer bookingid, String userid, String flightname, String source, String destination,
			String journydate, String bookingdate, String bookingstatus, List<Passenger> passenger) {
		super();
		this.bookingid = bookingid;
		this.userid = userid;
		this.flightname = flightname;
		this.source = source;
		this.destination = destination;
		this.journydate = journydate;
		this.bookingdate = bookingdate;
		this.bookingstatus = bookingstatus;
		this.passenger = passenger;
	}

	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", userid=" + userid + ", flightname=" + flightname + ", source="
				+ source + ", destination=" + destination + ", journydate=" + journydate + ", bookingdate="
				+ bookingdate + ", bookingstatus=" + bookingstatus + ", passenger=" + passenger + "]";
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	

}
