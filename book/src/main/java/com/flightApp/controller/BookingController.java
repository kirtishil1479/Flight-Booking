package com.flightApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightApp.entity.BookingRecord;
import com.flightApp.service.BookingServiceImpl;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingServiceImpl bookingServiceImpl;
	
	@PostMapping("/create")
	public long book(@RequestBody BookingRecord record) {
		return this.bookingServiceImpl.book(record);
		}
	
	@GetMapping("/get/{id}")
	public BookingRecord getBooking(@PathVariable long id) {
		return this.bookingServiceImpl.getBooking(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
