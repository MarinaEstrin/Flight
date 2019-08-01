package com.bluerbn.flight.baggage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bluerbn.flight.baggage.model.Destenation;

@Component
public class DestinationHandlerImpl implements DestenationHandler {

	@Autowired
	private DestenationDao destenationDao;
	
	@Override
	public Destenation getDestenation(long destenationId) {
		Destenation destenation = destenationDao.getDestenation(destenationId);
		if(destenation == null) {
			throw new RuntimeException("Not a valid destenation");
		}
		
		return destenation;
	}

}
