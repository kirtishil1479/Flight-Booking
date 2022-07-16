package com.flightApp.service;

import java.util.Date;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightApp.binding.Fare;
import com.flightApp.component.BookingException;
import com.flightApp.component.BookingStatus;
import com.flightApp.entity.BookingRecord;
import com.flightApp.entity.Inventory;
import com.flightApp.entity.Passenger;
import com.flightApp.repository.BookingRepository;
import com.flightApp.repository.InventoryRepository;

@Service
public class BookingServiceImpl implements BookingServiceI {
	
	private static final Logger logger=LoggerFactory.getLogger(BookingServiceImpl.class);
	
	private static final String fareURL="http://localhost:8082";
	
	
	
	@Autowired
	 BookingRepository bookinngRepository;
	 @Autowired
	 InventoryRepository inventoryRepository;
	 @Autowired
	 Fare fare;
	 
//	 private WebClient webclient;
	 
	 
	 
	 public long book(BookingRecord record) {
		
		logger.info("Calling fare to get fare"); 
		 
		logger.info("Calling inventory to get Inventory");
		 // check inventory 
		 Inventory inventory = this.inventoryRepository.findByFlightNumberAndFlightDate(record.getFlightNumber(),record.getFlightDate());
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
		logger.info("Successfully Save Booking");
	
		// 
		
		
		 return id;
		
	 }
	 
	 

	@Override
	public BookingRecord getBooking(long id) {
		return this.bookinngRepository.findById(id).get();
	}

	@Override
	public void updateStatus(String status, long bookingId) {
		this.bookinngRepository.findById(new Long(bookingId)).get();
	}

	@Override
	public void validateFareReactively(BookingRecord record) {
		
	}




	
	
	
	
	
	
}
