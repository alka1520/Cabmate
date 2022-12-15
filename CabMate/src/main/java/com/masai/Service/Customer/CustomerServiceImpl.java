package com.masai.Service.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entities.Admin;
import com.masai.Entities.Cab;
import com.masai.Entities.Customer;
import com.masai.Entities.User;
import com.masai.Exception.CustomerException;
import com.masai.Repository.AdminDao;
import com.masai.Repository.CabDao;
import com.masai.Repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {

		
		  Customer existingCustomer = customerDao.findByPhone(customer.getPhone());
		  
		  if(existingCustomer != null) throw new CustomerException("Your Phone number is already registered");
		  
		  return customerDao.save(customer);
		  
	}
	
	

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
	
		Customer existingCustomer = customerDao.findByPhone(customer.getPhone());
		  
		  if(existingCustomer != null) throw new CustomerException("Your Phone number is already registered");
		  
		  return customerDao.save(customer);
	}



	@Override
	public Customer deleteCustomer(String phone) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Customer getCustomer(String phone) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
