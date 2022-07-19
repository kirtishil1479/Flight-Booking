package com.flightApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightApp.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{

}
