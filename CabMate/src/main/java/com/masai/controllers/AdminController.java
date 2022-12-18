package com.masai.controllers;


import java.time.LocalDate;
import java.time.LocalDateTime;
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

import com.masai.DTO.AdminDTO;
import com.masai.DTO.LoginDTO;
import com.masai.Entities.Admin;
import com.masai.Entities.Booking;
import com.masai.Entities.Customer;
import com.masai.Entities.Driver;
import com.masai.Exception.LoginException;
import com.masai.Service.Admin.AdminService;
import com.masai.Service.Customer.CustomerService;
import com.masai.Service.Driver.DriverService;
import com.masai.Service.Login.LoginService;





@RestController
public class AdminController {

	
	@Autowired
	private LoginService logS;
	
	@Autowired
	private CustomerService customerS;
	
	@Autowired
	private AdminService adminS;
	
	@Autowired
	private DriverService driverService;
	
	
	@PostMapping("/login")
	public ResponseEntity<String> logInAdminHandler(@Valid @RequestBody AdminDTO dto) throws LoginException {
		LoginDTO ldto = new LoginDTO(dto.getPhonenumber(), dto.getPassword(), dto.getRole());
		String result = logS.login(ldto);

		return new ResponseEntity<String>(result,HttpStatus.OK );
		
		
	}
	
	@PostMapping("/logout")
	public String logoutAdminHandler(@Valid @RequestParam(required = false) String key) throws LoginException {
		return logS.logOut(key);
		
	}

	
	
	@PostMapping("/registeradmin")
	public ResponseEntity<Admin> createAdminHandler(@Valid @RequestBody Admin admin)	{
		Admin a=adminS.createAdmin(admin);
		
		return new ResponseEntity<Admin>(a, HttpStatus.CREATED);
		
	}
	
	
	
	@PostMapping("/registerDriver")
	public ResponseEntity<Driver> registerDriverHandler(@Valid @RequestBody Driver driver,@RequestParam String sessionid){
		Driver registeredDriver =adminS.addDriver(driver,sessionid);
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/deleteDriver")
	public ResponseEntity<Driver> deleteDriverHandler(@Valid @RequestParam Integer id){
		Driver driver=adminS.deleteDriver(id);
		return new ResponseEntity<Driver>(driver,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<Admin> deleteAdminHandler(@Valid @RequestParam String id){
		Admin admin=adminS.deleteAdmin(id);
		return new ResponseEntity<Admin>(admin,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<Admin> updateAdminHandler(@Valid @RequestBody Admin admin,@RequestParam String sessionid){
		Admin updatedadmin=adminS.updateAdmin(admin, sessionid);
		return new ResponseEntity<Admin>(updatedadmin,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updatePassword")
	public ResponseEntity<String> updatePasswordHandler(@Valid @RequestParam String email,@RequestParam String phone,@RequestParam String password){
		String msg=adminS.updatePassword(email, phone, password);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/admin")
	public ResponseEntity<Admin> viewdDetailsHandler(@Valid @RequestParam String id){
		Admin admin=adminS.viewAdminDetails(id);
		return new ResponseEntity<Admin>(admin,HttpStatus.OK);
	}
	
//	@PostMapping("/approveDriver")
//	public ResponseEntity<Driver> approveDriverHandler(@RequestBody Driver driver){
//		Driver registeredDriver =adminS.addDriver(driver);
//		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.OK);
//	}
	
	@GetMapping("/driversbyadmin")
	public ResponseEntity<List<Driver>> viewDriverListHandler(@Valid @RequestParam String sessionid){

		List<Driver> list=adminS.viewDrivers(sessionid);
		return new ResponseEntity<List<Driver>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/admins")
	public ResponseEntity<List<Admin>> viewAdminListHandler(@Valid @RequestParam String sessionid){

		List<Admin> list=adminS.viewAdmins(sessionid);
		return new ResponseEntity<List<Admin>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> viewCustomerListHandler(@Valid @RequestParam String sessionid){

		List<Customer> list=adminS.viewCustomers(sessionid);
		return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
	}

	
	@GetMapping("/bookings")
	public ResponseEntity<List<Booking>> viewBookingListHandler(@RequestParam String sessionid){

		List<Booking> list=adminS.viewBookings(sessionid);
		return new ResponseEntity<List<Booking>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/booking")
	public ResponseEntity<List<Booking>> viewBookingsByDateListHandler(@RequestParam String sessionid,@RequestParam String date){

	
		
		List<Booking> list=adminS.viewBookingsByDate(date,sessionid);
		return new ResponseEntity<List<Booking>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/bookingByDate")
	public ResponseEntity<List<Booking>> viewBookingsByDateSpanListHandler(@RequestParam String sessionid,@RequestParam String startdate,@RequestParam String enddate){

		List<Booking> list=adminS.viewBookingsByDateSpan(startdate, enddate, sessionid);
		return new ResponseEntity<List<Booking>>(list,HttpStatus.OK);
	}

	
}
