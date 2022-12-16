package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entities.Booking;
import com.masai.Entities.Cab;
import com.masai.Service.Cab.CabService;
import com.masai.Service.TripBooking.TripBookingService;

@RestController
public class TripBookingController {

	@Autowired
	private TripBookingService tripService;
	
	@Autowired
	private CabService cabService;
	
	
	@PostMapping("/trip")
	public ResponseEntity<Booking> bookTripHandler(@RequestBody Booking booking){
		
		Booking bookTrip = tripService.bookTrip(booking);
		
		return new ResponseEntity<Booking>(bookTrip,HttpStatus.OK);
	}
	

	@GetMapping("/cab/{status}")
	public ResponseEntity<List<Cab>> gitTripHandler(@PathVariable("status") Boolean status){
		
		List<Cab> clist = cabService.findByAvailbilityStatus(status);
		
		return new ResponseEntity<List<Cab>>(clist,HttpStatus.OK);
	}

	
	
}
