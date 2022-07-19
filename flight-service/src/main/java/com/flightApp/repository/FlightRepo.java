package com.flightApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightApp.entity.Flight;

public interface FlightRepo extends JpaRepository<Flight, Long> {

}
