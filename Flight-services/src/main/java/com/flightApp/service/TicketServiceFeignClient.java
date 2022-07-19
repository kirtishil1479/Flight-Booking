package com.flightApp.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("ticket-service")
public interface TicketServiceFeignClient {

	@PutMapping(value = "/ticket_service/cancelAllTickets/{id}")
	public void cancelAllTickets(@PathVariable Integer id);
	
}
