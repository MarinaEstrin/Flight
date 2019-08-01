package com.bluerbn.flight.ticket;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluerbn.flight.pricing.CouponHandler;
import com.bluerbn.flight.ticket.model.Ticket;
import com.bluerbn.flight.ticket.ro.TicketRO;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketHandler ticketHandler;
	
	@Autowired
	private CouponHandler couponHandler;
	
	@Override
	public TicketRO buyTicket(long ticketId, long couponId, double price) {
		Ticket ticket = ticketHandler.getTicket(ticketId);
		if(ticket == null || ticket.isSold()) {
			throw new RuntimeException("This ticket is not available");
		}
		ticket.setSold(true);
		ticket.setSaleDate(new Date());
		ticketHandler.saveTicket(ticket);
		
		price = couponHandler.getDiscount(couponId, price);
		
		return new TicketRO(ticketId, price);
	}

}
