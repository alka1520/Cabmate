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
import org.springframework.web.bind.annotation.PathVariable;
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
	public String logoutAdminHandler(@Valid @RequestParam(required = false) String sessionid) throws LoginException {
		return logS.logOut(sessionid);
	}


	@PostMapping("/registeradmin")
	public ResponseEntity<Admin> createAdminHandler(@Valid @RequestBody Admin admin)	{
		Admin a=adminS.createAdmin(admin);
		return new ResponseEntity<Admin>(a, HttpStatus.CREATED);
	}
	
	
	
	@PostMapping("/registerDriver")
	public ResponseEntity<Driver> registerDriverByAdminHandler(@Valid @RequestBody Driver driver,@RequestParam String sessionid){
		Driver registeredDriver =adminS.addDriverbyAdmin(driver,sessionid);
		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteDriver")
	public ResponseEntity<Driver> deleteDriverHandler(@Valid @RequestParam Integer id){
		Driver driver=adminS.deleteDriver(id);
		return new ResponseEntity<Driver>(driver,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/deleteAdmin/{sessionid}")
	public ResponseEntity<Admin> deleteAdminHandler(@PathVariable("sessionid") String sessionid){
		Admin admin=adminS.deleteAdmin(sessionid);
		return new ResponseEntity<Admin>(admin,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateAdmin/{sessionid}")
	public ResponseEntity<Admin> updateAdminHandler(@Valid @RequestBody Admin admin,@PathVariable("sessionid") String sessionid){
		Admin updatedadmin=adminS.updateAdmin(admin, sessionid);
		return new ResponseEntity<Admin>(updatedadmin,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updatePassword")
	public ResponseEntity<String> updatePasswordHandler(@Valid @RequestParam String email,@RequestParam String phone,@RequestParam String password){
		String msg=adminS.updatePassword(email, phone, password);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/admin/{sessionid}")
	public ResponseEntity<Admin> viewAdminDetailsHandler(@PathVariable String sessionid){
		Admin admin=adminS.viewAdminDetails(sessionid);
		return new ResponseEntity<Admin>(admin,HttpStatus.OK);
	}
	
//	@PostMapping("/approveDriver")
//	public ResponseEntity<Driver> approveDriverHandler(@RequestBody Driver driver){
//		Driver registeredDriver =adminS.addDriver(driver);
//		return new ResponseEntity<Driver>(registeredDriver,HttpStatus.OK);
//	}
	
	@GetMapping("/driversbyadmin/{sessionid}")
	public ResponseEntity<List<Driver>> viewDriverListHandler(@PathVariable("sessionid") String sessionid){

		List<Driver> list=driverService.viewDrivers(sessionid);
		return new ResponseEntity<List<Driver>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/admins/{sessionid}")
	public ResponseEntity<List<Admin>> viewAdminListHandler(@PathVariable("sessionid") String sessionid){

		List<Admin> list=adminS.viewAdmins(sessionid);
		return new ResponseEntity<List<Admin>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/customers/{sessionid}")
	public ResponseEntity<List<Customer>> viewCustomerListHandler(@PathVariable("sessionid") String sessionid){

		List<Customer> list=customerS.viewCustomers(sessionid);
		return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
	}

	
	@GetMapping("/bookings/{sessionid}")
	public ResponseEntity<List<Booking>> viewBookingListHandler(@PathVariable("sessionid") String sessionid){

		List<Booking> list=adminS.viewBookings(sessionid);
		return new ResponseEntity<List<Booking>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/booking/{sessionid}")
	public ResponseEntity<List<Booking>> viewBookingsByDateListHandler(@PathVariable("sessionid") String sessionid,@RequestParam String date){

	
		
		List<Booking> list=adminS.viewBookingsByDate(date,sessionid);
		return new ResponseEntity<List<Booking>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/bookingByDate/{sessionid}")
	public ResponseEntity<List<Booking>> viewBookingsByDateSpanListHandler(@PathVariable("sessionid") String sessionid,@RequestParam String startdate,@RequestParam String enddate){

		List<Booking> list=adminS.viewBookingsByDateSpan(startdate, enddate, sessionid);
		return new ResponseEntity<List<Booking>>(list,HttpStatus.OK);
	}

	
}
