package com.flightApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightApp.entity.Booking;
import com.flightApp.model.TicketRequest;
import com.flightApp.service.TicketServiceI;


@RestController
@RequestMapping("ticket_service")
public class TicketController {
	
	@Autowired
	private TicketServiceI ticketService;
	

	
	@PostMapping(value = "/saveTicket",produces = {"application/json"},consumes = {"application/json"})
	public ResponseEntity<Booking>  saveTicket(@RequestBody TicketRequest ticket) {
		 Booking saveTicket = ticketService.saveTicket(ticket);
		 return new ResponseEntity<Booking>(saveTicket,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/findTicket/{id}/{email}/{password}",produces = {"application/json"})
	public ResponseEntity<Booking>  findTicketById(@PathVariable Integer id, @PathVariable String email, @PathVariable String password) {
		 Booking findTicketById = ticketService.findTicketById(id,email,password);
		 return new ResponseEntity<Booking>(findTicketById,HttpStatus.OK);
	}
	
	@PutMapping(value = "/cancelTicketById/{id}/{email}/{password}",produces = {"application/json"})
	public ResponseEntity<Booking> cancelTicketById(@PathVariable Integer id,@PathVariable String email,@PathVariable String password) {
		Booking cancelTicketById = ticketService.cancelTicketById(id,email,password);
	
		return new ResponseEntity<Booking>(cancelTicketById,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/cancelAllTickets/{id}")
	public void cancelAllTickets(@PathVariable Integer id) {
		ticketService.cancelAllTickets(id);
	}

}
