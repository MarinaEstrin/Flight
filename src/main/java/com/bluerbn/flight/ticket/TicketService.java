package com.bluerbn.flight.ticket;

import com.bluerbn.flight.ticket.ro.TicketRO;

public interface TicketService {

	TicketRO buyTicket(long ticketId, long couponId, double price);

}
