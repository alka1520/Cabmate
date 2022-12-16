package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		
		Driver registeredDriver =driverService.registerDriver(driver);
		
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);
	}
	
	@PutMapping("/driver")
	public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver){
		
		Driver registeredDriver =driverService.updateDriver(driver);
		
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/driver/{phone}")
	public ResponseEntity<Driver> deleteDriver(@PathVariable("phone") String phone){
		
		Driver registeredDriver =driverService.deleteDriver(phone);
		
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);
	}
	
	@GetMapping("/driver/{phone}")
	public ResponseEntity<Driver> getDriver(@PathVariable("phone") String phone){
		
		Driver registeredDriver =driverService.viewDriver(phone);
		
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);
	}

}
