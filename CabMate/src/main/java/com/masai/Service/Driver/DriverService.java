package com.masai.Service.Driver;

import com.masai.Entities.Driver;
import com.masai.Exception.DriverException;

public interface DriverService {

	public Driver registerDriver(Driver driver) throws DriverException;
	
	public Driver updateDriver(Driver driver) throws DriverException;
	
	public Driver deleteDriver(String phone) throws DriverException;
	
	public Driver viewDriver(String phone) throws DriverException;
}
