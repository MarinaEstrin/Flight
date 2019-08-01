package com.bluerbn.flight.baggage;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bluerbn.flight.baggage.model.CheckedInBaggage;
import com.bluerbn.flight.baggage.model.Destenation;

@Component
public class BaggageHandlerImpl implements BaggageHandler {

	@Autowired
	private BaggageDao baggageDao;
	
	@Override
	public CheckedInBaggage getChekedInBaggage(String baggageId) {
		return baggageDao.getCheckedInBaggage(baggageId);
	}

	@Override //Should be transactional
	public void checkInBaggage(String baggageId, Destenation destenation) {
		CheckedInBaggage baggage = new CheckedInBaggage(null, destenation.getId(), baggageId, new Date());
		baggageDao.saveOrUpdateCheckedInBaggage(baggage);
	}

}
