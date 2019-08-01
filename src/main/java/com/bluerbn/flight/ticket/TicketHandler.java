package com.bluerbn.flight.ticket;

import com.bluerbn.flight.ticket.model.Ticket;

public interface TicketHandler {

	Ticket getTicket(long ticketId);

	void saveTicket(Ticket ticket);

}
