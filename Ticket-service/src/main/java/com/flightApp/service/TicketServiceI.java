package com.flightApp.service;

import com.flightApp.entity.Booking;
import com.flightApp.model.TicketRequest;

public interface TicketServiceI {
	
	public Booking saveTicket(TicketRequest ticketRequest);
	public Booking findTicketById(Integer id, String email, String password);
	public Booking cancelTicketById(Integer id, String email, String password);
	public void cancelAllTickets(Integer id);

}
