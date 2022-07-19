package com.flightApp.service;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;


import com.flightApp.entity.Flight;

import com.flightApp.repository.FlightRepo;

public class FlightService implements FlightServiceI {
	
	@Autowired
	private FlightRepo flightRepo;
	
	@Override
	public Flight getBooking(long id) {
		return this.flightRepo.findById(id).get();
	}

	@Override
	public void updateStatus(String status, long bookingId) {
		this.flightRepo.findById(new Long(bookingId)).get();
	}

	@Override
	public long book(Flight booking) {
		
		 // check inventory 
		 Inventory inventory = this.inventoryRepository.findByFlightNumberAndFlightDate(booking.getFlightNumber(),booking.getFlightDate());
		if(!inventory.isAvailable(record.getPassengers().size()))
		{
			throw new BookingException("No More Seats available");
		}
		 
		logger.info("Successfully check Inventory"+inventory);
		// update inventory
		inventory.setAvailable(inventory.getAvailable()-record.getPassengers().size());
		this.inventoryRepository.saveAndFlush(inventory);
		logger.info("Successfully updated Inventory");
		
		// save Booking 
		record.setStatus(BookingStatus.BOOKING_CONFIRMED);
		Set<Passenger> passengers = record.getPassengers();
		passengers.forEach(passenger ->passenger.setBookingRecord(record));
		record.setBookingDate(new Date());
		long id = this.bookinngRepository.save(record).getId();
	
		
		
		 return id;
		return 0;
	}

}
