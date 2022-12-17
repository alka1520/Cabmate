package com.masai.Service.Cab;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entities.Cab;
import com.masai.Repository.CabDao;

@Service
public class CabServiceImpl implements CabService {

	@Autowired
	private CabDao cabDao;
	
	@Override
	public List<Cab> findByAvailbilityStatus(Boolean availbilityStatus) {
		
		List<Cab> cabList = cabDao.findByAvailbilityStatus(true);
		
		
		return cabList;
	}

	
}
