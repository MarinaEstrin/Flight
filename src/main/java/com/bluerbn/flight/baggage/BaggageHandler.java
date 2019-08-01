package com.bluerbn.flight.baggage;

import com.bluerbn.flight.baggage.model.CheckedInBaggage;
import com.bluerbn.flight.baggage.model.Destenation;

public interface BaggageHandler {

	CheckedInBaggage getChekedInBaggage(String baggageId);

	void checkInBaggage(String baggageId, Destenation destenation);

}
