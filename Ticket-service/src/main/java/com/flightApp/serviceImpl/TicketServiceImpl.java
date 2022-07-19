package com.flightApp.serviceImpl;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.flightApp.entity.Booking;
import com.flightApp.entity.Passenger;
import com.flightApp.exception.NoDataFoundException;
import com.flightApp.model.AppConstant;
import com.flightApp.model.Schedule;
import com.flightApp.model.TicketRequest;
import com.flightApp.repository.TicketRepository;
import com.flightApp.service.FlightServiceFeignClient;
import com.flightApp.service.TicketServiceI;
import com.flightApp.service.UserServiceFeignClient;



@Service
public class TicketServiceImpl implements TicketServiceI {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private FlightServiceFeignClient flightService;
	
	@Autowired
	private UserServiceFeignClient userService;
	

	@Override
	public Booking saveTicket(TicketRequest ticketRequest) {
		
		Boolean valideUser = userService.valideUser(ticketRequest.getUserid(), ticketRequest.getUserPassword());
		if(valideUser) {
			Schedule schedule = flightService.getScheduleById(ticketRequest.getScheduleid());
			
			if(schedule.getAvailseats()>= ticketRequest.getPassenger().size()) {
				Booking booking=new Booking();
				booking.setBookingid(0);
				
				booking.setUserid(ticketRequest.getUserid());
				booking.setFlightname(schedule.getFlight().getFlightname());
				booking.setJournydate(schedule.getDate());
				
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				booking.setBookingdate(dtf.format(now));
				
			
				
				List<Passenger> passengers = ticketRequest.getPassenger();
				passengers.forEach(passenger -> passenger.setBooking(booking));
				booking.setPassenger(passengers);
			
				return ticketRepository.save(booking);
			}else {
				throw new NoDataFoundException("Seats Not Available");
			}
		}else {
			throw new NoDataFoundException("You don't have authority.");
		}
	}


	@Override
	public Booking findTicketById(Integer id, String email, String password) {
		Boolean valideUser = userService.valideUser(email, password);
		if(valideUser) {
			boolean existsById = ticketRepository.existsById(id);
			if(existsById) {
				return ticketRepository.findById(id).get();
			}else {
				throw new NoDataFoundException("Ticket Details Not Found");
			}
		}else {
			throw new NoDataFoundException("You don't have authority.");
		}
	}

	//@CircuitBreaker(name = "default", fallbackMethod="ServiceFallBack")
	@Override
	public Booking cancelTicketById(Integer id, String email, String password) {
		Boolean valideUser = userService.valideUser(email, password);
			if(valideUser) {
			boolean existsById = ticketRepository.existsById(id);
			if(existsById) {
				 Booking booking = ticketRepository.findById(id).get();
				 booking.setBookingstatus(AppConstant.BOOKING_CANCEL);
				
				 return ticketRepository.save(booking);
			}else {
				throw new NoDataFoundException("Ticket Details Not Found");
			}
		}else {
			throw new NoDataFoundException("You don't have authority.");
		}
	}
	
	@Override
	public void cancelAllTickets(Integer id) {
		List<Booking> findByScheduleid = ticketRepository.findByScheduleid(id);
		findByScheduleid.stream().forEach(ticket->ticket.setBookingstatus(AppConstant.BOOKING_CANCEL));
		ticketRepository.saveAll(findByScheduleid);
	}
	

}


