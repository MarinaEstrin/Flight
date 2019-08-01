package com.bluerbn.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluerbn.flight.ticket.TicketService;
import com.bluerbn.flight.ticket.ro.TicketRO;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketService ticketService; 
	
	@PostMapping("/buy")
	public TicketRO buyTicket(long ticketId, long couponId, double price) {
		return ticketService.buyTicket(ticketId, couponId, price);
	}

}
