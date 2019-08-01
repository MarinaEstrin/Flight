package com.bluerbn.flight.baggage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluerbn.flight.baggage.model.CheckedInBaggage;
import com.bluerbn.flight.baggage.model.Destenation;

@Service
public class BaggageServiceImpl implements BaggageService {
	
	@Autowired
	private BaggageHandler baggageHandler;
	
	@Autowired
	private DestenationHandler destenationHandler;

	@Override
	public boolean checkInBaggage(long destenationId, String baggageId) {
		CheckedInBaggage cib = baggageHandler.getChekedInBaggage(baggageId);
		if (cib != null) {
			throw new RuntimeException("This baggage id is already checked in");
		}
		
		Destenation destenation = destenationHandler.getDestenation(destenationId);
		baggageHandler.checkInBaggage(baggageId, destenation);
		
		return true;
	}

}
