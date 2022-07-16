package com.flightApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.flightApp.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{
	
	Inventory findByFlightNumberAndFlightDate(String flightNumber, String flightDate);

}
