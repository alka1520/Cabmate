package com.masai.Service.Driver;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.masai.Entities.Booking;
import com.masai.Entities.Cab;
import com.masai.Entities.Driver;
import com.masai.Entities.UserSession;
import com.masai.Exception.DriverException;
import com.masai.Repository.BookingDao;
import com.masai.Repository.DriverDao;
import com.masai.Repository.UserSessionDao;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DriverDao driverDao;
	
	@Autowired
	private UserSessionDao usersessionDao;

	@Autowired
	private BookingDao bookingDao;
	
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
	

		driver1.setCab(cab);
		cab.setDriver(driver1);
		
		
		return driverDao.save(driver1);

	}

	@Override
	public Driver updateDriver(Driver driver,String sessionid) throws DriverException {
		
		UserSession usersession=usersessionDao.findBySessionId(sessionid);
		
		if(usersession==null) {
			throw new DriverException("User not login");
		}
		
		//Optional<Driver> existingDriver = driverDao.findById(usersession.getUserid());
		
		//if(existingDriver==null) throw new DriverException("please enter correct details...");
		
		driver.setDriverID(usersession.getUserid());
		
		return driverDao.save(driver);

	}

	@Override
	public Driver deleteDriver(String sessionid) throws DriverException {
 
       UserSession usersession=usersessionDao.findBySessionId(sessionid);
		
		if(usersession==null) {
			throw new DriverException("User not login");
		}
		
        Optional<Driver> existingDriver = driverDao.findById(usersession.getUserid());
//		
//		if(existingDriver==null) throw new DriverException("please enter correct details...");
		
		 driverDao.delete(existingDriver.get());
		 
		 return existingDriver.get();
	}

	@Override
	public Driver viewDriver(String sessionid) throws DriverException {
		
        UserSession usersession=usersessionDao.findBySessionId(sessionid);
		
		if(usersession==null) {
			throw new DriverException("User not login");
		}
		
        Optional<Driver> driver = driverDao.findById(usersession.getUserid());
		
		
		return driver.get();
		
	}

	@Override
	public List<Booking> viewAllBooking(String sessionid) throws DriverException {
		  UserSession usersession=usersessionDao.findBySessionId(sessionid);
			
		if(usersession==null) {
				throw new DriverException("User not login");
		}
		
		Integer cabid=driverDao.findById(usersession.getUserid()).get().getCab().getCabId();
		
//		List<Booking> bookingDetails=bookingDao.getBookingListByCabid(cabid);
//		
//		return bookingDetails;
		return null;
		
	}
	
	

}
