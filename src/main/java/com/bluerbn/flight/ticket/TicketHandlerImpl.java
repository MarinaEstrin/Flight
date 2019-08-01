package com.bluerbn.flight.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bluerbn.flight.ticket.model.Ticket;

@Component
public class TicketHandlerImpl implements TicketHandler {

	@Autowired
	private TicketDao ticketDao;
	
	@Override
	public Ticket getTicket(long ticketId) {
		return ticketDao.getTicket(ticketId);
	}

	@Override
	public void saveTicket(Ticket ticket) {
		ticketDao.saveTicket(ticket);
	}

}
