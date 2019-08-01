package com.bluerbn.flight.baggage;

import com.bluerbn.flight.baggage.model.CheckedInBaggage;

public interface BaggageDao {

	CheckedInBaggage getCheckedInBaggage(String baggageId);

	CheckedInBaggage saveOrUpdateCheckedInBaggage(CheckedInBaggage checkedInBaggage);

}
