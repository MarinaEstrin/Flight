package com.bluerbn.flight.baggage;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.bluerbn.flight.baggage.model.Destenation;

@Component // Should be @Repository
public class DestenationDaoImpl implements DestenationDao {
	
	private static List<Destenation> destenations = new ArrayList<>();
	
	@PostConstruct
	private void init() {
		destenations.add(new Destenation(1, "TLV"));
		destenations.add(new Destenation(2, "LON"));
		destenations.add(new Destenation(3, "NYC"));
		destenations.add(new Destenation(4, "DLS"));
		destenations.add(new Destenation(5, "AMS"));
	}
	
	@Override
	public Destenation getDestenation(long id) {
		return destenations.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	}
	
}
