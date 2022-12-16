package com.masai.Service.Login;

import com.masai.DTO.AdminDTO;
import com.masai.DTO.LoginDTO;
import com.masai.Exception.LoginException;
import com.masai.Exception.LogoutException;

public interface LoginService {
	
	public String logOut(String key)throws LogoutException;
	
	public String login(LoginDTO dto)throws LoginException;
	
	
}
