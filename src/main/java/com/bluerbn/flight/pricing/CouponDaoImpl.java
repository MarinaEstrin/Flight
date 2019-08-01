package com.bluerbn.flight.pricing;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.bluerbn.flight.pricing.model.Coupon;

@Component // Should be @Repository
public class CouponDaoImpl implements CouponDao {
	
	private static List<Coupon> coupons = new ArrayList<>();
	
	@PostConstruct
	private void init() {
		coupons.add(new Coupon(1));
		coupons.add(new Coupon(5));
		coupons.add(new Coupon(10));
		coupons.add(new Coupon(15));
	}
	
	@Override
	public Coupon getCoupon(long id) {
		return coupons.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	}
	
}
