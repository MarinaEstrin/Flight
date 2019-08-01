package com.bluerbn.flight.pricing;

public interface CouponHandler {

	double getDiscount(long couponId, double price);

}
