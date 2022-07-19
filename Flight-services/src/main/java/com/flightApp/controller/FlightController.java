package com.flightApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightApp.entity.Flight;
import com.flightApp.service.FlightServiceImpl;

@RestController
@RequestMapping(value = "flight_service")
public class FlightController {
	
	@Autowired
	private FlightServiceImpl flightService;
	

	
	@PostMapping(value = "/addFlight/{emailid}/{password}",produces = {"application/json"})
	public ResponseEntity<Flight>  addFlight(@RequestBody Flight flight, @PathVariable String emailid, @PathVariable String password) {
		
		Flight newFlight = flightService.addFlight(flight,emailid,password);
		return new ResponseEntity<Flight>(newFlight,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllFlight/{emailid}/{password}",produces = {"application/json"})
	public ResponseEntity< List<Flight>> findAllFlight(@PathVariable String emailid, @PathVariable String password) {
		  List<Flight> findAllFlight = flightService.findAllFlight(emailid,password);
		  return new ResponseEntity<List<Flight>>(findAllFlight,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getFlight/{flightId}/{emailid}/{password}",produces = {"application/json"})
	public Optional<Flight> findFlightById(@PathVariable Integer flightId,@PathVariable String emailid, @PathVariable String password) {
		Optional<Flight> newFlight = flightService.findFlightById(flightId,emailid,password);
		return newFlight;
	}
	


	

}
