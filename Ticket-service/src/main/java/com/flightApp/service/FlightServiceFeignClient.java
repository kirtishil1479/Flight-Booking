package com.flightApp.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.flightApp.model.Schedule;

@FeignClient("flight-service")
public interface FlightServiceFeignClient {
	
	@GetMapping(value = "/flight_service/getScheduleById/{scheduleId}",produces = {"application/json"})
	public Schedule getScheduleById(@PathVariable Integer scheduleId);
	
	@PutMapping(value = "/flight_service/updateFlightSchedule",produces = {"application/json"},consumes = {"application/json"})
	public Schedule updateFlightSchedule(@RequestBody Schedule flightSchedule);
	
	@PutMapping(value = "/flight_service/updateFlightSeats/{scheduleId}/{seats}",produces = {"application/json"})
	public void updateFlightSeats(@PathVariable Integer scheduleId,@PathVariable Integer seats);
}


