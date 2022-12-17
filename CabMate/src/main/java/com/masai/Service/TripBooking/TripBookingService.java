package com.masai.Service.TripBooking;

import java.util.List;

import com.masai.DTO.BookingDTO;
import com.masai.Entities.Booking;

public interface TripBookingService {

	public Booking bookTrip(Booking booking);
	
	public List<Booking> getAllBookingsOfCustomer();
	
}
