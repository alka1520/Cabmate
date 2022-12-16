package com.masai.Service.Driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entities.Driver;
import com.masai.Exception.DriverException;
import com.masai.Exception.DriverException;
import com.masai.Exception.DriverException;
import com.masai.Repository.DriverDao;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DriverDao driverDao;

	@Override
	public Driver registerDriver(Driver driver)throws DriverException {
		//System.out.println(driver);
		return driverDao.save(driver);
	}
	
	

}
