package com.masai.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.DTO.DriverDTO;
import com.masai.DTO.LoginDTO;
import com.masai.Entities.Booking;
import com.masai.Entities.Driver;
import com.masai.Exception.LoginException;
import com.masai.Service.Driver.DriverService;
import com.masai.Service.Login.LoginService;



@RestController
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	
	@Autowired
	private LoginService logS;
	

	@PostMapping("/driverlogin")
	public ResponseEntity<String> logInAdminHandler(@Valid @RequestBody DriverDTO dto) throws LoginException {
		LoginDTO ldto = new LoginDTO(dto.getPhonenumber(), dto.getPassword(), dto.getRole());
		String result = logS.login(ldto);
		return new ResponseEntity<String>(result,HttpStatus.OK );
	}
	
	@PostMapping("/driverlogout")
	public String logoutAdminHandler(@Valid @RequestParam(required = false) String sessionid) throws LoginException {
		return logS.logOut(sessionid);
	}
	
	@PutMapping("/updatedriverPassword")
	public ResponseEntity<String> updatePasswordHandler(@Valid @RequestParam String email,@RequestParam String phone,@RequestParam String password){
		String msg=driverService.updatePassword(email, phone, password);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}

	@PostMapping("/drivers")
	public ResponseEntity<Driver> registerDriverHandler(@Valid @RequestBody Driver driver){
		
		Driver registeredDriver =driverService.registerDriver(driver);
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);

	}
	
	@PutMapping("/drivers")
	public ResponseEntity<Driver> updateDriverHandler(@Valid @RequestBody Driver driver,@RequestParam String sessionid){
		
		Driver registeredDriver =driverService.updateDriver(driver,sessionid);
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/drivers")
	public ResponseEntity<Driver> deleteDriverHandler(@Valid @RequestParam String sessionid){
		
		Driver registeredDriver =driverService.deleteDriver(sessionid);	
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);
	}
	
	@GetMapping("/drivers")
	public ResponseEntity<Driver> getDriverHandler(@Valid @RequestParam String sessionid){
		
		Driver registeredDriver =driverService.viewDriver(sessionid);	
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);
	}
	
	@GetMapping("/bookingList")
	public ResponseEntity<List<Booking>> viewAllBookingDetailsHandler(@Valid @RequestParam String sessionid){
		
		List<Booking> bookingList = driverService.viewAllBooking(sessionid);	
		return new ResponseEntity<List<Booking>>(bookingList,HttpStatus.CREATED);
	}

}
