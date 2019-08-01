package com.bluerbn.flight.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

public class MyCache { //Better with generics, but didnt have time
	
	private Map<Object, Object> cache = new HashMap<>();
	private Map<Object, Long> expiryMap = new HashMap<>();

	private Timer expiryTimer;
	private long timeToLiveSec;
	
	public static MyCache generateCache(long timeToLiveSec) {
		return new MyCache(timeToLiveSec);
	}
	
	private MyCache(long timeToLiveSec) {
		this.timeToLiveSec = timeToLiveSec;
		this.expiryTimer = new Timer(true);
		this.expiryTimer.schedule(new TimerTask() {		
			@Override
			public void run() {
				List<Object> keysToEvict = new ArrayList<>();
				for(Entry<Object, Long> entry : expiryMap.entrySet()) {
					if(entry.getValue() <= System.currentTimeMillis()) {
						keysToEvict.add(entry.getKey());
					}
				}
				
				for(Object key : keysToEvict) {
					cache.remove(key);
				}
			}
		}, 1000, 1000);
	}
	
	public void put(Object key, Object value) {
		cache.put(key, value);
		expiryMap.put(key, (System.currentTimeMillis() + (timeToLiveSec * 1000)));	
	}
	
	public Object get(Object key) {
		return cache.get(key);
	}

}
