package com.masai.Service.Cab;

import java.util.List;

import com.masai.Entities.Cab;

public interface CabService {

	//public Cab findByAvailbilityStatus(Boolean availbilityStatus);
	
	public List<Cab> findByAvailbilityStatus(Boolean availbilityStatus);
}
