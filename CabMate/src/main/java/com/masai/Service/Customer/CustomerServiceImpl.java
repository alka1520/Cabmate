package com.masai.Service.Customer;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.masai.Entities.Admin;
import com.masai.Entities.Cab;
import com.masai.Entities.Customer;
import com.masai.Entities.User;
import com.masai.Entities.Verification;
import com.masai.Exception.CustomerException;
import com.masai.Repository.AdminDao;
import com.masai.Repository.CabDao;
import com.masai.Repository.CustomerDao;
import com.masai.Repository.VerificationDao;
import com.masai.Service.EmailSender.EmailSenderService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private VerificationDao vDao;
	
	@Autowired
	private EmailSenderService senderService;
	
	
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {

		
		  Customer existingCustomer = customerDao.findByPhone(customer.getPhone());
		  
		  if(existingCustomer != null) throw new CustomerException("Your Phone number is already registered");
		  
		  Verification verify=new Verification();
		  
		  Integer generateOtp= new Random().nextInt(999999);
		  
		  verify.setOtp(generateOtp+"");
		  verify.setEmail(customer.getEmail());
		  vDao.save(verify);
		  senderService.sendotp(customer.getEmail(), "your otp for verification ", "your otp is "+generateOtp);
		  
		  return customerDao.save(customer);
		  
	}
	
	

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
	
		
		// In usersession customer is present or not 
		Customer existingCustomer = customerDao.findByPhone(customer.getPhone());
		  
		  if(existingCustomer == null) throw new CustomerException("Your Phone number is already registered");
			 customer.setCustomerID(existingCustomer.getCustomerID());
			 return customerDao.save(customer);
			 	 
	}



	@Override
	public Customer deleteCustomer(String phone) throws CustomerException {
		Customer existingCustomer = customerDao.findByPhone(phone);
		  
		  if(existingCustomer == null) throw new CustomerException("Customer is not found with phone number :"+phone);
		  
		   customerDao.delete(existingCustomer);
		   return existingCustomer;
	}



	@Override
	public Customer getCustomer(String phone) throws CustomerException {
		
		Customer existingCustomer = customerDao.findByPhone(phone);
		  
		  if(existingCustomer == null) throw new CustomerException("Customer is not found with phone number :"+phone);
		  
		   return existingCustomer;
		
		
	}



	@Override
	public Boolean verifyOtp(String otp, String email) throws CustomerException {
		Optional<Verification> verify=vDao.findById(email);
		System.out.println(verify.get().getOtp());
		if(!verify.isPresent()) {
			throw new CustomerException("Enter valid email");
		}
		if(verify.get().getOtp().equals(otp) ){
			
			return true;
		}else {
			throw new CustomerException("Enter valid otp");
		}
		
	}
	
	

}
