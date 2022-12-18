package com.masai.Service.Driver;


import java.util.List;

import com.masai.Entities.Booking;
import com.masai.Entities.Driver;
import com.masai.Exception.DriverException;


public interface DriverService {

	public Driver registerDriver(Driver driver) throws DriverException;

	public Driver updateDriver(Driver driver,String sessionid) throws DriverException;
	
	public Driver deleteDriver(String sessionid) throws DriverException;
	
	public Driver viewDriver(String sessionid) throws DriverException;

	public List<Driver> viewDrivers(String sessionid); 
	
	public List<Booking> viewAllBooking(String sessionid)throws DriverException;

	public String updatePassword(String email, String phone, String password);
}
