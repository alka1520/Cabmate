package com.masai.Service.Login;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.AdminDTO;
import com.masai.DTO.LoginDTO;
import com.masai.Entities.Admin;
import com.masai.Entities.Customer;
import com.masai.Entities.Driver;
import com.masai.Entities.UserSession;
import com.masai.Exception.LoginException;
import com.masai.Repository.AdminDao;
import com.masai.Repository.CustomerDao;
import com.masai.Repository.DriverDao;
import com.masai.Repository.UserSessionDao;

import net.bytebuddy.utility.RandomString;

	
	@Service
	public class LoginServiceImpl implements LoginService{

		 @Autowired
		 private AdminDao usera;
		
		 @Autowired
		 private CustomerDao userc;
		
		 @Autowired
		 private DriverDao userd;
		
		 @Autowired
		 private UserSessionDao usersession;

		 @Override
		 public String logOut(String key)throws LoginException {
		 	UserSession us =  usersession.findBySessionId(key);
		 	if(us != null) {
		 		usersession.delete(us);
		 		return "Logged Out!";
		 	}else throw new LoginException("Error Occured Unable to log out !");
			
		 }

		 @Override
		 public String login(LoginDTO dto) throws LoginException {
			
		 	UserSession currentUserSession;
			
		 	if(dto.getRole()==1) {
				
		 		Admin admin = usera.findByPhone(dto.getPhonenumber());
		 		if(admin == null) {
		 			throw new LoginException("Please Enter a valid mobile number");
		 		}
				
		 		if(usersession.findById(admin.getAdminId()).isPresent()) {
		 			throw new LoginException("User already Logged In with this number");
		 		}
		 	    if(admin.getPassword().equals(dto.getPassword())) {
					
		 			String key= RandomString.make(6);
					
		 			 currentUserSession = new UserSession(admin.getAdminId(), key, LocalDateTime.now(), admin.getRole());
					
		 			 usersession.save(currentUserSession);
		 			 return currentUserSession.toString();
		 	    }
		 	    else
		 			throw new LoginException("Please Enter a valid password");
			 
				
		 	}else if(dto.getRole()==2) {
		 		Driver driver = userd.findByPhone(dto.getPhonenumber());
		 		if(driver == null) {
		 			throw new LoginException("Please Enter a valid mobile number");
		 		}
		 		if(usersession.findById(driver.getDriverID()).isPresent()) {
		 			throw new LoginException("User already Logged In with this number");
		 		}
		 	    if(driver.getPassword().equals(dto.getPassword())) {
					
		 			String key= RandomString.make(6);
					
		 		    currentUserSession = new UserSession(driver.getDriverID(), key, LocalDateTime.now(), driver.getRole());
					
		 		    usersession.save(currentUserSession);
		 		    return currentUserSession.toString();
		 		}
		 	    else
		 			throw new LoginException("Please Enter a valid password");
			 
			    
		 	}else if(dto.getRole()==3) {
		 		Customer customer = userc.findByPhone(dto.getPhonenumber());
		 		if(customer == null) {
		 			throw new LoginException("Please Enter a valid mobile number");
		 		}
		 		if(usersession.findById(customer.getUserID()).isPresent()) {
		 			throw new LoginException("User already Logged In with this number");
		 		}
		 	    if(customer.getPassword().equals(dto.getPassword())) {
					
		 			String key = RandomString.make(6);
					
		 			 currentUserSession = new UserSession(customer.getUserID(), key, LocalDateTime.now(), customer.getRole());
		 			 usersession.save(currentUserSession);	
		 			 return currentUserSession.toString();
					
		 		}else
		 			throw new LoginException("Please Enter a valid password");
				 
			    
		 	}
		 	else
		 		throw new LoginException("Invalid user");
			 
		
		   }

		



	}

		


