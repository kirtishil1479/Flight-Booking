package com.flightApp.service;

import com.flightApp.entity.Flight;


public interface FlightServiceI {
	
	public long book(Flight booking);
	
	public Flight getBooking(long id);
	
	public void updateStatus(String status,long bookingId);

}
