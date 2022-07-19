package com.flightApp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 long id;
	private String flightNumber;
	private String source;
	private String destination;
	private String flightDate;
	private String fare;
	private String status;
	private Date bookingDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
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
	public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", flightNumber=" + flightNumber + ", source=" + source + ", destination="
				+ destination + ", flightDate=" + flightDate + ", fare=" + fare + ", status=" + status
				+ ", bookingDate=" + bookingDate + "]";
	}
	public Flight(long id, String flightNumber, String source, String destination, String flightDate, String fare,
			String status, Date bookingDate) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.source = source;
		this.destination = destination;
		this.flightDate = flightDate;
		this.fare = fare;
		this.status = status;
		this.bookingDate = bookingDate;
	}
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
