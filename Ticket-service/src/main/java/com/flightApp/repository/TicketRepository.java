package com.flightApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightApp.entity.Booking;
import com.flightApp.model.Schedule;

public interface TicketRepository extends JpaRepository<Booking, Integer> {
	public List<Booking> findByScheduleid(Integer id);
	
	public Schedule saveFlightSchedule(Schedule flightSchedule, String emailid, String password);
}
