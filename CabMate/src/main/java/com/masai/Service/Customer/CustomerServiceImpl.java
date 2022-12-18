package com.masai.Service.Customer;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entities.Admin;
import com.masai.Entities.Customer;
import com.masai.Entities.UserSession;
import com.masai.Entities.Verification;
import com.masai.Exception.AdminException;
import com.masai.Exception.CustomerException;
import com.masai.Exception.LoginException;
import com.masai.Repository.CustomerDao;
import com.masai.Repository.UserSessionDao;
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
	
	@Autowired
	private UserSessionDao usersessiondao;

	
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
	public Customer updateCustomer(Customer customer,String sessionid) throws CustomerException {
	
		if(usersessiondao.findBySessionId(sessionid) == null) {
			throw new LoginException("login first !");
		}
		Customer existingCustomer = customerDao.findById(usersessiondao.findBySessionId(sessionid).getUserid()).get();
		customer.setCustomerID(existingCustomer.getCustomerID());
		return customerDao.save(customer);
			 	 
	}



	@Override
	public Customer deleteCustomer(String sessionid) throws CustomerException {
		if(usersessiondao.findBySessionId(sessionid) == null) {
			throw new LoginException("login first !");
		}
		Customer existingCustomer = customerDao.findById(usersessiondao.findBySessionId(sessionid).getUserid()).get();
		  
		customerDao.delete(existingCustomer);
		usersessiondao.delete(usersessiondao.findBySessionId(sessionid));
		return existingCustomer;
	}



	@Override
	public Customer getCustomer(String sessionid) throws CustomerException {
		
		UserSession us=usersessiondao.findBySessionId(sessionid);
		if(us!=null) {
			Customer customer = customerDao.findById(us.getUserid()).get();	
			return customer;
		}
		else {
			throw new AdminException("Not logged in, LogIn first");
		}
		
		
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
	
	@Override
	public List<Customer> viewCustomers(String sessionid) {
		UserSession us=usersessiondao.findBySessionId(sessionid);
		if(us!=null) {
			List<Customer> list=customerDao.findAll();
			if(list.size()==0) {
				throw new CustomerException("No customer Exists");
			}
			return list;
		}else {
			throw new LoginException("Not logged in, LogIn first");
		}	
	}
	
	@Override
	public String updatePassword(String email, String phone, String password) {
		Customer a=customerDao.findByPhone(phone);
		if(a.getEmail().equals(email)) {
			a.setPassword(password);
			customerDao.save(a);
			return "Password Updated Successfully!";
		}
		throw new LoginException("User doesn't exist");
	}

}
