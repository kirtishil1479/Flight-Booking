package com.flightApp.service;

import com.flightApp.entity.BookingRecord;
import com.flightApp.entity.Inventory;

public interface BookingServiceI {
	
//	Inventory findByFlightNumberAndFlightDate(String flightNumber, String flightDate);
	
	
	
	
	public long book(BookingRecord record);
	
	public BookingRecord getBooking(long id);
	
	public void updateStatus(String status,long bookingId);
	
	public void validateFareReactively(BookingRecord record);
	

	
	
	
	
	

}
