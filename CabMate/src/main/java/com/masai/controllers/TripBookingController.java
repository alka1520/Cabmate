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

import com.masai.Entities.Booking;
import com.masai.Entities.Cab;
import com.masai.Entities.Driver;
import com.masai.Service.Cab.CabService;
import com.masai.Service.TripBooking.TripBookingService;

@RestController
public class TripBookingController {

	@Autowired
	private TripBookingService tripService;
	
	@Autowired
	private CabService cabService;
	
	
	@PostMapping("/trip/{sessionid}")
	public ResponseEntity<Booking> bookTripHandler(@Valid @RequestBody Booking booking ,@PathVariable("sessionid") String sessionid){
		
		Booking bookTrip = tripService.bookTrip(booking,sessionid);
		
		return new ResponseEntity<Booking>(bookTrip,HttpStatus.OK);
	}
	

	@GetMapping("/cab/{status}")
	public ResponseEntity<List<Cab>> getAvailableCabsHandler(@Valid @PathVariable("status") Boolean status){
		
		List<Cab> clist = cabService.findByAvailbilityStatus(status);
		
		return new ResponseEntity<List<Cab>>(clist,HttpStatus.OK);
	}

	@GetMapping("/trip/{sessionid}")
	public ResponseEntity<List<Booking>> getAllBookingDetailsOfCustomerHandler(@PathVariable("sessionid") String sessionid){
		
		List<Booking> bookingList = tripService.getAllBookingsOfCustomer(sessionid);
		
		return new ResponseEntity<List<Booking>>(bookingList,HttpStatus.OK);
	}
	
	@PutMapping("/updateTripStatus/{bookingId}/{sessionid}")
	public ResponseEntity<String> updateDriverHandler(@PathVariable("bookingId") Integer bookingId, @PathVariable("sessionid") String sessionid){
		
		String status =tripService.deleteBooking(bookingId,sessionid);
		return new ResponseEntity<String>(status,HttpStatus.CREATED);
	}
	
//	@DeleteMapping("/trip/{bookingId}/{sessionid}")
//	public ResponseEntity<Booking> deleteBookingOfCustomerHandler(@PathVariable("bookingId") Integer bookingId, @PathVariable("sessionid") String sessionid){
//		
//		Booking booking = tripService.deleteBooking(bookingId,sessionid);
//		
//		return new ResponseEntity<Booking>(booking,HttpStatus.OK);
//	}
	
}
