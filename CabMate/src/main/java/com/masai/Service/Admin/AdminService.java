package com.masai.Service.Admin;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.masai.Entities.Admin;
import com.masai.Entities.Booking;
import com.masai.Entities.Customer;
import com.masai.Entities.Driver;
import com.masai.Exception.AdminException;
import com.masai.Exception.DriverException;



public interface AdminService {

	
	
	public Admin createAdmin(Admin admin);
	
	public Driver addDriver(Driver driver,String sessionid);
	
	public Driver deleteDriver(Integer id) throws DriverException;
	
	public Admin deleteAdmin(String sessionid) throws AdminException;
	
	public Admin updateAdmin(Admin admin,String sessionid);
	
	public String updatePassword(String email,String phone,String password);
	
	public Admin viewAdminDetails(String sessionid);
	
	public List<Driver> viewDrivers(String sessionid);
	
	public List<Admin> viewAdmins(String sessionid);
	
	public List<Customer> viewCustomers(String sessionid);
	
	public List<Booking> viewBookings(String sessionid);
	
	public List<Booking> viewBookingsByDate(String date,String sessionid);
	
	public List<Booking> viewBookingsByDateSpan(String startdate,String enddate,String sessionid);
}
