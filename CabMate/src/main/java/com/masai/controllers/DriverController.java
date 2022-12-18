package com.masai.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entities.Booking;
import com.masai.Entities.Driver;
import com.masai.Service.Driver.DriverService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	

	@PostMapping("/drivers")
	public ResponseEntity<Driver> registerDriver(@Valid @RequestBody Driver driver){
		
		Driver registeredDriver =driverService.registerDriver(driver);
		
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);
	}
	
	@PutMapping("/drivers")
	public ResponseEntity<Driver> updateDriver(@Valid @RequestBody Driver driver,@RequestParam String sessionid){
		
		Driver registeredDriver =driverService.updateDriver(driver,sessionid);
		
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/drivers")
	public ResponseEntity<Driver> deleteDriver(@Valid @RequestParam String sessionid){
		
		Driver registeredDriver =driverService.deleteDriver(sessionid);
		
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);
	}
	
	@GetMapping("/drivers")
	public ResponseEntity<Driver> getDriver(@Valid @RequestParam String sessionid){
		
		Driver registeredDriver =driverService.viewDriver(sessionid);
		
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);
	}
	
	@GetMapping("/bookingList")
	public ResponseEntity<List<Booking>> viewAllBookingDetails(@Valid @RequestParam String sessionid){
		
		List<Booking> bookingList = driverService.viewAllBooking(sessionid);
		
		return new ResponseEntity<List<Booking>>(bookingList,HttpStatus.CREATED);
	}

}
