package com.bluerbn.flight.baggage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.bluerbn.flight.baggage.model.CheckedInBaggage;

@Component // Should be @Repository
public class BaggageDaoImpl implements BaggageDao {
	
	private static List<CheckedInBaggage> checkedInBaggages = new ArrayList<>();
	
	@PostConstruct
	private void init() {
		checkedInBaggages.add(new CheckedInBaggage(1L, 1, "a", new Date()));
		checkedInBaggages.add(new CheckedInBaggage(2L, 2, "b", new Date()));
		checkedInBaggages.add(new CheckedInBaggage(3L, 1, "c", new Date()));
		checkedInBaggages.add(new CheckedInBaggage(4L, 5, "d", new Date()));
	}
	
	@Override
	public CheckedInBaggage getCheckedInBaggage(String baggageId) {
		return checkedInBaggages.stream().filter(x -> x.getBaggageId().equals(baggageId)).findFirst().orElse(null);
	}
	
	@Override
	public CheckedInBaggage saveOrUpdateCheckedInBaggage(CheckedInBaggage checkedInBaggage) {
		//saving in real DB would not require the following logic
		CheckedInBaggage b = getCheckedInBaggage(checkedInBaggage.getBaggageId());
		if (b == null) { //create
			checkedInBaggages.add(checkedInBaggage);
			return checkedInBaggage;
		} else { // update
			BeanUtils.copyProperties(checkedInBaggage, b);
			return b;
		}
	}

}
