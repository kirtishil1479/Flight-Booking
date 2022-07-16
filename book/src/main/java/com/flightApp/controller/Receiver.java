package com.flightApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.flightApp.component.BookingStatus;
import com.flightApp.service.BookingServiceImpl;

@RestController
public class Receiver {

	BookingServiceImpl bookingServiceImpl;

	@Autowired
	public Receiver(BookingServiceImpl bookingServiceImpl) {
		super();
		this.bookingServiceImpl = bookingServiceImpl;
	}
	
	
	public void processMessage(long bookingId) {
		this.bookingServiceImpl.updateStatus(BookingStatus.CHECKED_IN, bookingId);
	}
	
	
	
	
	
	
}
