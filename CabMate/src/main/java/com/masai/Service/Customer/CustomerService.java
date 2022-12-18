package com.masai.Service.Customer;

import java.util.List;

import com.masai.Entities.Admin;
import com.masai.Entities.Customer;
import com.masai.Exception.CustomerException;

public interface CustomerService {

	public Customer registerCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer,String sessionid) throws CustomerException;
	
	public List<Customer> viewCustomers(String sessionid); // all customers
	
	public Customer deleteCustomer(String sessionid) throws CustomerException;
	
	public Customer getCustomer(String sessionid) throws CustomerException;
	
	public Boolean verifyOtp(String otp,String email) throws CustomerException;
	
	public String updatePassword(String email, String phone, String password);
	
}
