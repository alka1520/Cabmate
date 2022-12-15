package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.DTO.AdminDTO;
import com.masai.Entities.Admin;
import com.masai.Exception.LoginException;
import com.masai.Service.Admin.AdminService;
import com.masai.Service.Login.LoginService;



@RestController
public class AdminController {

	
	@Autowired
	private LoginService logS;
	
	@Autowired
	private AdminService adminS;
	
	@PostMapping("/login")
	public ResponseEntity<String> logInCustomer(@RequestBody AdminDTO dto) throws LoginException {
		
		
		String result = logS.adminlogin(dto);
		

		
		return new ResponseEntity<String>(result,HttpStatus.OK );
		
		
	}
	
	
	@PostMapping("/registeradmin")
	public ResponseEntity<Admin> createAdminHandler(@RequestBody Admin admin)	{
		System.out.println(admin.getAddress()+admin.getName());
		Admin a=adminS.createAdmin(admin);
		
		return new ResponseEntity<Admin>(a, HttpStatus.CREATED);
		
	}

	
}
