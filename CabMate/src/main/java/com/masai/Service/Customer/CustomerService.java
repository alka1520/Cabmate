package com.masai.Service.Customer;

import com.masai.Entities.Admin;
import com.masai.Entities.Customer;
import com.masai.Exception.CustomerException;

public interface CustomerService {

	public Customer registerCustomer(Customer customer) throws CustomerException;
	
	
	//public Admin registerAdmin(Admin admin);
	
	public Customer updateCustomer(Customer customer) throws CustomerException;
	
	
	public Customer deleteCustomer(String phone) throws CustomerException;
	
	public Customer getCustomer(String phone) throws CustomerException;
	
	
}