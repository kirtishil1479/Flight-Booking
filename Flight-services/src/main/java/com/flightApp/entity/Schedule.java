package com.flightApp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer scheduleid;
	
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date date;
	private String time;
	
	
	@ManyToOne(targetEntity = Flight.class,fetch = FetchType.EAGER)
	private Flight flight;
	
	private Integer availseats;
	private Integer price;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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

	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Schedule() {
		// TODO Auto-generated constructor stub
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Schedule(Integer scheduleid,Date date, String time, Flight flight, Integer availseats,
			Integer price, String status) {
		super();
		this.scheduleid = scheduleid;
		this.date = date;
		this.time = time;
	
		this.flight = flight;
		this.availseats = availseats;
		this.price = price;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Schedule [scheduleid=" + scheduleid + ", date=" + date + ", time=" + time + ",  flight=" + flight + ", availseats=" + availseats + ", price=" + price + ", status=" + status + "]";
	}
	
}
