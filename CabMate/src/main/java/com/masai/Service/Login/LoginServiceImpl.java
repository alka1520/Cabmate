package com.masai.Service.Login;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.AdminDTO;
import com.masai.Entities.Admin;
import com.masai.Entities.UserSession;
import com.masai.Exception.LoginException;
import com.masai.Repository.AdminDao;
import com.masai.Repository.UserSessionDao;


import net.bytebuddy.utility.RandomString;


@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private AdminDao usera;
	
	@Autowired
	private UserSessionDao usersession;
	
	@Override
	public String adminlogin(AdminDTO logindto) {

			Admin admin = usera.findByPhone(logindto.getPhonenumber());
			
			
			if(admin == null) {
				
				throw new LoginException("Please Enter a valid mobile number");
				
			}
			
			//else
			Optional<UserSession> validUserSessionOpt =  usersession.findById(admin.getAdminId());
			
		
			if(validUserSessionOpt.isPresent()) {
				
				throw new LoginException("User already Logged In with this number");
				
			}
			
			if(admin.getPassword().equals(logindto.getPassword())) {
				
				String key= RandomString.make(6);
				
				UserSession currentUserSession = new UserSession(admin.getAdminId(), key, LocalDateTime.now(), admin.getRoll());
				
				usersession.save(currentUserSession);

				return currentUserSession.toString();
			}
			else
				throw new LoginException("Please Enter a valid password");
			
		}

	}


