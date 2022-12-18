package com.masai.Service.TripBooking;

import java.util.List;

import com.masai.DTO.BookingDTO;
import com.masai.Entities.Booking;
import com.masai.Exception.BookingException;

public interface TripBookingService {

	public Booking bookTrip(Booking booking,String sessionid);
	
	public List<Booking> getAllBookingsOfCustomer(String sessionid);
	
	public Booking deleteBooking(Integer bookingId,String sessionid) throws BookingException;
	
}
