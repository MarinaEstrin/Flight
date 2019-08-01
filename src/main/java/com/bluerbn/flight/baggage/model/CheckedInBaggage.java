package com.bluerbn.flight.baggage.model;

import java.util.Date;
import java.util.Random;

public class CheckedInBaggage {
	
	private static Random random = new Random();
	
	private long id;
	
	private long destenationId;
	
	private String baggageId;
	
	private Date checkInDate;

	public CheckedInBaggage() {
	}

	public CheckedInBaggage(Long id, long destenationId, String baggageId, Date checkInDate) {
		if(id != null) { // Should be auto gen by DB
			this.id = id;
		} else {
			this.id = random.nextLong();
		}
		
		this.destenationId = destenationId;
		this.baggageId = baggageId;
		this.checkInDate = checkInDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDestenationId() {
		return destenationId;
	}

	public void setDestenationId(long destenationId) {
		this.destenationId = destenationId;
	}

	public String getBaggageId() {
		return baggageId;
	}

	public void setBaggageId(String baggageId) {
		this.baggageId = baggageId;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baggageId == null) ? 0 : baggageId.hashCode());
		result = prime * result + ((checkInDate == null) ? 0 : checkInDate.hashCode());
		result = prime * result + (int) (destenationId ^ (destenationId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
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
		CheckedInBaggage other = (CheckedInBaggage) obj;
		if (baggageId == null) {
			if (other.baggageId != null)
				return false;
		} else if (!baggageId.equals(other.baggageId))
			return false;
		if (checkInDate == null) {
			if (other.checkInDate != null)
				return false;
		} else if (!checkInDate.equals(other.checkInDate))
			return false;
		if (destenationId != other.destenationId)
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
}
