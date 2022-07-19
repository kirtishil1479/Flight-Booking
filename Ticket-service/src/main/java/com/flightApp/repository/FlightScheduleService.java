package com.flightApp.repository;

import java.util.List;

import com.flightApp.model.Schedule;

public interface FlightScheduleService {
	
	public Schedule saveFlightSchedule(Schedule flightSchedule, String emailid, String password);
	public List<Schedule> getAllSchedule();
	public Schedule getScheduleById(Integer scheduleId);
	
	public Schedule cancelFlightSchedule(Integer id); 
	
}
