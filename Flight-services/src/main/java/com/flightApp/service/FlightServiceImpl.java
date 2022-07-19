package com.flightApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightApp.entity.Flight;
import com.flightApp.exception.NotFoundException;
import com.flightApp.repository.FlightRepository;


@Service
public class FlightServiceImpl implements FlightServiceI{
	
	
	@Autowired
	private FlightRepository repository;
	
	@Autowired
	private UserServiceFeignClient userClient;
	
	@Autowired
	private AdminServiceFeignClient adminClient;
	
	
	@Override
	public Flight addFlight(Flight flight,String emailid,String password) {
		Boolean valideAdmin = adminClient.valideAdmin(emailid, password);
		if(valideAdmin) {
			Flight newFlight= repository.save(flight);
			return newFlight;
		}else {
			throw new NotFoundException("You Dont Have Authority");
		}
	}
	
	@Override
	public List<Flight> findAllFlight(String emailid,String password) {
		Boolean valideAdmin = adminClient.valideAdmin(emailid, password);
		if(valideAdmin) {
			List<Flight> flights = repository.findAll();
			return flights;
				
		}else {
			throw new NotFoundException("You Dont Have Authority");
		}
	}	
	
	@Override
	public Optional<Flight> findFlightById(Integer id,String emailid,String password) {
		Boolean valideAdmin = adminClient.valideAdmin(emailid, password);
		if(valideAdmin) {
			Optional<Flight> findById = repository.findById(id);
			if(findById.isEmpty()) {
				throw new NotFoundException("Flight Not Found");
			}else {
				return findById;
			}	
		}else {
			
			throw new NotFoundException("You Dont Have Authority");
		}
	}
	
	
	
	@Override
	public List<Flight> findAllFlightByUser() {
		Boolean user = userClient.valideUser();
		if(user) {
			List<Flight> flights = repository.findAll();
			return flights;
				
		}else {
			throw new NotFoundException("You Dont Have Authority");
		}
	}	
	
	public Optional<Flight> findFlightByIdByUser(Integer id) {
		Boolean user = userClient.valideUser();
		if(user) {
			Optional<Flight> findById = repository.findById(id);
			if(findById.isEmpty()) {
				throw new NotFoundException("Flight Not Found");
			}else {
				return findById;
			}	
		}else {
			
			throw new NotFoundException("You Dont Have Authority");
		}
	}
	
	
	
	
	

}
