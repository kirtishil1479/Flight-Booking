package com.flightApp.service;

import java.util.List;
import java.util.Optional;

import com.flightApp.entity.Flight;

public interface FlightServiceI {
	
	public Flight addFlight(Flight flight,String emailid,String password);
	public List<Flight> findAllFlight(String emailid,String password);
	public Optional<Flight> findFlightById(Integer id,String emailid,String password);
	
	public List<Flight> findAllFlightByUser();
	public Optional<Flight> findFlightByIdByUser(Integer id);

}
