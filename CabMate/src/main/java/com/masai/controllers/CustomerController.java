package com.masai.controllers;

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

import com.masai.DTO.CustomerDTO;
import com.masai.DTO.LoginDTO;
import com.masai.Entities.Customer;
import com.masai.Entities.Verification;
import com.masai.Exception.LoginException;
import com.masai.Service.Customer.CustomerService;
import com.masai.Service.Login.LoginService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@Autowired
	private LoginService logS;
	

	@PostMapping("/customerlogin")
	public ResponseEntity<String> logInAdminHandler(@Valid @RequestBody CustomerDTO dto) throws LoginException {
		LoginDTO ldto = new LoginDTO(dto.getPhonenumber(), dto.getPassword(), dto.getRole());
		String result = logS.login(ldto);
		return new ResponseEntity<String>(result,HttpStatus.OK );
	}
	
	@PostMapping("/customerlogout")
	public String logoutAdminHandler(@Valid @RequestParam(required = false) String sessionid) throws LoginException {
		return logS.logOut(sessionid);
	}
	
	@PutMapping("/updatecustomerPassword")
	public ResponseEntity<String> updatePasswordHandler(@Valid @RequestParam String email,@RequestParam String phone,@RequestParam String password){
		String msg=customerService.updatePassword(email, phone, password);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customer/{sessionid}")
	public ResponseEntity<Customer> getCustomerHandler(@Valid @PathVariable("sessionid") String sessionid){
		
		Customer customer = customerService.getCustomer(sessionid);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> registerCustomerHandler(@Valid @RequestBody Customer customer){
		
		Customer newCustomer = customerService.registerCustomer(customer);	
		return new ResponseEntity<Customer>(newCustomer,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/customer/{sessionid}")
	public ResponseEntity<Customer> updateCustomerHandler(@Valid @RequestBody Customer customer, @PathVariable("sessionid") String sessionid){
		
		Customer updatedCustomer = customerService.updateCustomer(customer,sessionid);
		
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
	}
	
	@DeleteMapping("/customer/{phone}")
	public ResponseEntity<Customer> deleteCustomerHandler(@Valid @PathVariable("phone") String phone ){
		
		Customer deletedCustomer = customerService.deleteCustomer(phone);
		
		return new ResponseEntity<Customer>(deletedCustomer,HttpStatus.OK);
	}
	
	@PostMapping("/verify")
	public ResponseEntity<Boolean> verifyCustomerHandler(@Valid @RequestBody  Verification verify){
		
		Boolean res=customerService.verifyOtp(verify.getOtp(), verify.getEmail());
		
		
		return new ResponseEntity<Boolean>(res,HttpStatus.CREATED);
		
	}

	
	
	
	
}
