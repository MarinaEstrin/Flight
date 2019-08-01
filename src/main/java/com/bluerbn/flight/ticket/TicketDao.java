package com.bluerbn.flight.ticket;

import com.bluerbn.flight.ticket.model.Ticket;

public interface TicketDao {

	Ticket getTicket(long id);

	Ticket saveTicket(Ticket ticket);

}
