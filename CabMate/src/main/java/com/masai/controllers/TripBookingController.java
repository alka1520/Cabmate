package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entities.Booking;
import com.masai.Service.TripBooking.TripBookingService;

@RestController
public class TripBookingController {

	@Autowired
	private TripBookingService tripService;
	
	
	@PostMapping("/trip")
	public ResponseEntity<Booking> bookTripHandler(@RequestBody Booking booking){
		
		Booking bookTrip = tripService.bookTrip(booking);
		
		return new ResponseEntity<Booking>(bookTrip,HttpStatus.OK);
	}
	
	
}
