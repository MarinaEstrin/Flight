package com.bluerbn.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bluerbn.flight.baggage.BaggageService;

@RestController
@RequestMapping("/baggage")
public class BaggageController {
	
	@Autowired
	private BaggageService baggageService; 
	
	
	@PostMapping("/checkIn")
	public boolean checkInBaggage(@RequestParam long destenationId, @RequestParam String baggageId) {
		return baggageService.checkInBaggage(destenationId, baggageId);
	}

}
