package com.flightApp;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.flightApp.entity.BookingRecord;
import com.flightApp.entity.Inventory;
import com.flightApp.entity.Passenger;
import com.flightApp.repository.BookingRepository;
import com.flightApp.repository.InventoryRepository;
import com.flightApp.service.BookingServiceImpl;

@SpringBootApplication
public class BookApplication implements CommandLineRunner {
	
	private static final Logger logger=LoggerFactory.getLogger(BookApplication.class);
	
	 @Autowired
	 private BookingRepository bookinngRepository;
	 
	 @Autowired
	 private BookingServiceImpl bookingServiceImpl;
	 
	 @Autowired
	 private InventoryRepository inventoryRepository;
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		Inventory[] invs= {
				new Inventory("KD100","18-DEC-2022",100),
				new Inventory("KD101","18-DEC-2022",100),
				new Inventory("KD102","18-DEC-2022",100),
				new Inventory("KD103","18-DEC-2022",100),
				new Inventory("KD104","18-DEC-2022",100),
				new Inventory("KD105","18-DEC-2022",100),
				new Inventory("KD106","18-DEC-2022",100),
				};
		Arrays.asList(invs).forEach(inventory ->this.inventoryRepository.save(inventory));
		
		
		
		
		BookingRecord booking=new BookingRecord("BF101","NYC","SFO","18-DEC-2022",new Date(),"101");
		Set<Passenger> passengers=new HashSet<>();
		passengers.add(new Passenger("Kirtishil", "Dhiwar","male",booking));
		
		booking.setPassengers(passengers);
		long record = this.bookingServiceImpl.book(booking);
		logger.info("Booking Successfully saved."+record);
		
		logger.info("Looking to Load booking record......");
		logger.info("Result:"+this.bookingServiceImpl.getBooking(record));
	
		

		
	
	}
}
