package com.bluerbn.flight.pricing.model;

import java.util.Random;

public class Coupon {
	
	private static Random random = new Random();
	
	private long id;
	
	private double discount;
		
	public Coupon() {
		
	}
	
	public Coupon(long id) {
		this.id = id;
		
		int rnd = random.nextInt(3);
		switch (rnd) {
		case 0:
			this.discount = 0.1;
			break;
		case 1:
			this.discount = 0.5;
			break;
		case 2:
			this.discount = 0.6;
			break;
		}
	}

	public static Random getRandom() {
		return random;
	}

	public static void setRandom(Random random) {
		Coupon.random = random;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Coupon other = (Coupon) obj;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
}
