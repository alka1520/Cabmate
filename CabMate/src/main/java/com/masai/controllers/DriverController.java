package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entities.Driver;
import com.masai.Service.Driver.DriverService;
import org.springframework.web.bind.annotation.RequestBody;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@PostMapping("/driver")
	public ResponseEntity<Driver> registerDriver(@RequestBody Driver driver){
		System.out.println(driver);
		Driver registeredDriver =driverService.registerDriver(driver);
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);
	}

}
