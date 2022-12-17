package com.masai.Service.Driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entities.Cab;
import com.masai.Entities.Driver;
import com.masai.Exception.DriverException;
import com.masai.Repository.DriverDao;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DriverDao driverDao;

	@Override
	public Driver registerDriver(Driver driver)throws DriverException{
		
		Cab cab = new Cab();
		cab.setCabNumber(driver.getCab().getCabNumber());
		cab.setCartype(driver.getCab().getCartype());
		cab.setRate(driver.getCab().getRate());
		cab.setAvailbilityStatus(true);
		
		Driver driver1 = new Driver();
		driver1.setName(driver.getName());
		driver1.setEmail(driver.getEmail());
		driver1.setAddress(driver.getAddress());
		driver1.setPassword(driver.getPassword());
		driver1.setLicenseNo(driver.getLicenseNo());
		driver1.setPhone(driver.getPhone());
		driver1.setRating(driver.getRating());
		driver1.setRoll(driver.getRoll());
	
		driver1.setCab(cab);
		cab.setDriver(driver1);
		
		
		return driverDao.save(driver1);
	}
	
	

}
