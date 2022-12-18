package com.masai.Service.Driver;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entities.Admin;
import com.masai.Entities.Booking;
import com.masai.Entities.Cab;
import com.masai.Entities.Driver;
import com.masai.Entities.UserSession;
import com.masai.Exception.AdminException;
import com.masai.Exception.DriverException;
import com.masai.Exception.LoginException;
import com.masai.Repository.BookingDao;
import com.masai.Repository.DriverDao;
import com.masai.Repository.UserSessionDao;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DriverDao driverDao;
	
	@Autowired
	private UserSessionDao usersessiondao;

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
		
		UserSession usersession=usersessiondao.findBySessionId(sessionid);
		if(usersession==null) {
			throw new DriverException("User not login");
		}
		driver.setDriverID(usersession.getUserid());
		return driverDao.save(driver);

	}

	@Override
	public Driver deleteDriver(String sessionid) throws DriverException {
 
       UserSession usersession=usersessiondao.findBySessionId(sessionid);
		if(usersession==null) {
			throw new DriverException("User not login");
		}	
        Driver existingDriver = driverDao.findById(usersession.getUserid()).orElseThrow(() -> new DriverException("driver not found"));	
		driverDao.deleteById(existingDriver.getDriverID());;
		usersessiondao.delete(usersessiondao.findBySessionId(sessionid)); 
		return existingDriver;
	}

	@Override
	public Driver viewDriver(String sessionid) throws DriverException {
		
        UserSession usersession=usersessiondao.findBySessionId(sessionid);
		
		if(usersession==null) {
			throw new DriverException("User not login");
		}
		
        Optional<Driver> driver = driverDao.findById(usersession.getUserid());
		
		
		return driver.get();
		
	}

	@Override
	public List<Booking> viewAllBooking(String sessionid) throws DriverException {
		  UserSession usersession=usersessiondao.findBySessionId(sessionid);
			
		if(usersession==null) {
				throw new DriverException("User not login");
		}
		
		Cab cab =driverDao.findById(usersession.getUserid()).get().getCab();	
		List<Booking> bookingDetails=bookingDao.findByCab(cab);
		
		return bookingDetails;
		
	}
	
	@Override
	public List<Driver> viewDrivers(String sessionid) {
		UserSession us=usersessiondao.findBySessionId(sessionid);
		if(us!=null) {
			List<Driver> list=driverDao.findAll();
			if(list.size()==0) {
				throw new DriverException("No Driver Exists");
			}
			return list;
		}else {
			throw new LoginException("Not logged in, LogIn first");
		}
	}
	
	@Override
	public String updatePassword(String email, String phone, String password) {
		Driver d = driverDao.findByPhone(phone);
		if(d.getEmail().equals(email)) {
			d.setPassword(password);
			driverDao.save(d);
			return "Password Updated Successfully!";
		}
		throw new DriverException("User doesn't exist");
	}

	

}
