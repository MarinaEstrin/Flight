package com.bluerbn.flight.pricing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bluerbn.flight.cache.MyCache;
import com.bluerbn.flight.pricing.model.Coupon;

@Component
public class CouponHandlerImpl implements CouponHandler {

	private MyCache couponCache = MyCache.generateCache(30);
	
	@Autowired
	private CouponDao couponDao;
	
	@Override
	public double getDiscount(long couponId, double price) {
		Coupon cached = (Coupon) couponCache.get(couponId);
		if(cached == null) {
			Coupon coupon = couponDao.getCoupon(couponId);
			couponCache.put(couponId, coupon);
			cached = coupon;
		}
		
		if(cached != null) {
			return price * cached.getDiscount();
		}
		
		return price;
	}

}
