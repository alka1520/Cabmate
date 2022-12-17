package com.masai.controllers;

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

import com.masai.Entities.Admin;
import com.masai.Entities.Customer;
import com.masai.Service.Customer.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/customer")
	public ResponseEntity<Customer> getCustomer(@RequestParam String phone){
		
		Customer customer = customerService.getCustomer(phone);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
		
		Customer newCustomer = customerService.registerCustomer(customer);
		
		return new ResponseEntity<Customer>(newCustomer,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		
		Customer updatedCustomer = customerService.updateCustomer(customer);
		
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
	}
	
	@DeleteMapping("/customer/{phone}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("phone") String phone ){
		
		Customer deletedCustomer = customerService.deleteCustomer(phone);
		
		return new ResponseEntity<Customer>(deletedCustomer,HttpStatus.OK);
	}

	
	
	
	
}
