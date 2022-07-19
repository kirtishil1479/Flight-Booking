package com.flightApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightApp.entity.Flight;

import com.flightApp.service.FlightService;

@RestController
public class controller {
	
	@Autowired
	private FlightService flightService;
	
	

	@PostMapping("/create")
	public long book(@RequestBody Flight record) {
		return this.flightService.book(record);
		}
	
	@GetMapping("/get/{id}")
	public Flight getBooking(@PathVariable long id) {
		return this.flightService.getBooking(id);
	}
	
	
	
}
