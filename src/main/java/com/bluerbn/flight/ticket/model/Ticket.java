package com.bluerbn.flight.ticket.model;

import java.util.Date;

public class Ticket {
	
	private long id;
	
	private boolean sold = false; //default false
	
	private Date saleDate;

	public Ticket() {
	}

	public Ticket(long id, boolean sold, Date saleDate) {
		this.id = id;
		this.sold = sold;
		this.saleDate = saleDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((saleDate == null) ? 0 : saleDate.hashCode());
		result = prime * result + (sold ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (id != other.id)
			return false;
		if (saleDate == null) {
			if (other.saleDate != null)
				return false;
		} else if (!saleDate.equals(other.saleDate))
			return false;
		if (sold != other.sold)
			return false;
		return true;
	}
	
}
