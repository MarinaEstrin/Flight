package com.bluerbn.flight.ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.bluerbn.flight.ticket.model.Ticket;

@Component // Should be @Repository
public class TicketDaoImpl implements TicketDao {
	
	private static List<Ticket> tickets = new ArrayList<>();
	
	@PostConstruct
	private void init() {
		tickets.add(new Ticket(0, true, new Date()));
		tickets.add(new Ticket(1, false, new Date()));
		tickets.add(new Ticket(2, false, new Date()));
		tickets.add(new Ticket(3, false, new Date()));
		tickets.add(new Ticket(4, true, new Date()));
		tickets.add(new Ticket(5, false, new Date()));
	}
	
	@Override
	public Ticket getTicket(long id) {
		return tickets.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	}
	
	@Override
	public Ticket saveTicket(Ticket ticket) {
		tickets.add(ticket);
		return ticket;
	}

}
