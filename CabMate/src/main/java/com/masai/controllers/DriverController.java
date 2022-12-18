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
	public ResponseEntity<String> logInAdminHandler(@Valid @RequestBody DriverDTO dto) {
		LoginDTO ldto = new LoginDTO(dto.getPhonenumber(), dto.getPassword(), dto.getRole());
		String result = logS.login(ldto);
		return new ResponseEntity<String>(result,HttpStatus.OK );
	}
	
	@PostMapping("/driverlogout/{sessionid}")
	public String logoutAdminHandler(@PathVariable("sessionid") String sessionid) {
		return logS.logOut(sessionid);
	}
	
	@PutMapping("/updatedriverPassword")
	public ResponseEntity<String> updatePasswordHandler(@Valid @RequestParam String email,@RequestParam String phone,@RequestParam String password){
		String msg=driverService.updatePassword(email, phone, password);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}

	@PostMapping("/registerdriver")
	public ResponseEntity<Driver> registerDriverHandler(@Valid @RequestBody Driver driver){
		
		Driver registeredDriver =driverService.registerDriver(driver);
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);

	}
	
	@PutMapping("/updatedriver/{sessionid}")
	public ResponseEntity<Driver> updateDriverHandler(@Valid @RequestBody Driver driver,@PathVariable("sessionid") String sessionid){
		
		Driver registeredDriver =driverService.updateDriver(driver,sessionid);
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletedriver/{sessionid}")
	public ResponseEntity<Driver> deleteDriverHandler(@PathVariable("sessionid") String sessionid){
		
		Driver registeredDriver =driverService.deleteDriver(sessionid);	
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);
	}
	
	@GetMapping("/driver/{sessionid}")
	public ResponseEntity<Driver> getDriverHandler(@PathVariable("sessionid") String sessionid){
		
		Driver registeredDriver =driverService.viewDriver(sessionid);	
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);
	}
	
	@GetMapping("/bookingList/{sessionid}")
	public ResponseEntity<List<Booking>> viewAllBookingDetailsHandler(@PathVariable("sessionid") String sessionid){
		
		List<Booking> bookingList = driverService.viewAllBooking(sessionid);	
		return new ResponseEntity<List<Booking>>(bookingList,HttpStatus.CREATED);
	}

}
