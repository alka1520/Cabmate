package com.masai.Service.TripBooking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.BookingDTO;
import com.masai.Entities.Booking;
import com.masai.Entities.Cab;
import com.masai.Entities.Customer;
import com.masai.Exception.BookingException;
import com.masai.Exception.CabException;
import com.masai.Exception.CustomerException;
import com.masai.Repository.BookingDao;
import com.masai.Repository.CabDao;
import com.masai.Repository.CustomerDao;
import com.masai.Service.Cab.CabService;

@Service
public class TripBookingImpl implements TripBookingService{

	@Autowired
	private CabDao cabDao;
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Booking bookTrip(Booking booking) {
		
		//get customer id form userSession
		
		Customer customer = customerDao.findByPhone("12345");
		
		if(customer == null) throw new CustomerException("Customer not login yet..");
		
		List<Cab> cabList = cabDao.findByAvailbilityStatus(true);
		
		if(cabList.size() != 0) {
			
			//LocalDateTime localDT = LocalDateTime.parse(booking.getFromDate());
			
			//It is tight coupling
			//We will convert it into loose coupling when we conneted to front end
			//only change is assign cab object to argumented cab object
			
			Cab cab = null;
			
			for(Cab c : cabList) {
				 cab = c;
				break;
			}
			
			cab.setAvailbilityStatus(false);
			//cab status updated
			cabDao.save(cab);
			
			
			Random random = new Random();
			
			booking.setKm(random.nextDouble(100));
			booking.setBill(booking.getKm() * 10);
			booking.setBookingStatus(true);
			
			//Association mapping cab - booking
			booking.setCab(cab);
			
			//Association mapping customer - booking
			booking.setCustomer(customer);

			
			return bookingDao.save(booking);
			
		}else 
			throw new CabException("Cab not available right now..");
		
	}

	@Override
	public List<Booking> getAllBookingsOfCustomer() {
		
		//get customer id from user session - get cust id 
		
		Customer customer = customerDao.findByPhone("12345");
		
		if(customer == null) throw new CustomerException("Customer not login yet..");
		
		List<Booking> bookingList = bookingDao.findByCustomer(customer);
		
		if(!bookingList.isEmpty())
			return bookingList;
		else
			throw new BookingException("Bookings are not found of customer :"+customer.getName());
		
	}

	
	
	
}
