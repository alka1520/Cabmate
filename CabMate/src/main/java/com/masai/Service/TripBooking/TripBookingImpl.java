package com.masai.Service.TripBooking;

import java.time.LocalDate;
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
import com.masai.Exception.LoginException;
import com.masai.Repository.BookingDao;
import com.masai.Repository.CabDao;
import com.masai.Repository.CustomerDao;
import com.masai.Repository.UserSessionDao;
import com.masai.Service.Cab.CabService;

@Service
public class TripBookingImpl implements TripBookingService{

	@Autowired
	private CabDao cabDao;
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private UserSessionDao usersessionDao;
	
	@Override
	public Booking bookTrip(Booking booking ,String sessionid) {
		
		if(usersessionDao.findBySessionId(sessionid) == null) {
			throw new LoginException("login first !");
		}
				
		Customer customer = customerDao.findById(usersessionDao.findBySessionId(sessionid).getUserid()).get();		
		List<Cab> cabList = cabDao.findByAvailbilityStatus(true);
		
		if(cabList.size() != 0) {
			String fdate = booking.getFromDate()+"";
			String tdate = booking.getToDate()+"";
			
			LocalDate localDT1 = LocalDate.parse(fdate);
			LocalDate localDT2 = LocalDate.parse(tdate);
			
			booking.setFromDate(localDT1);
			booking.setToDate(localDT2);
			
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
			booking.setBill(booking.getKm() * cab.getRate());
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
	public List<Booking> getAllBookingsOfCustomer(String sessionid) {
		
		if(usersessionDao.findBySessionId(sessionid) == null) {
			throw new LoginException("login first !");
		}
		
		Customer customer = customerDao.findById(usersessionDao.findBySessionId(sessionid).getUserid()).get();
		if(customer == null) throw new CustomerException("Customer not login yet..");
		
		List<Booking> bookingList = bookingDao.findByCustomer(customer);
		
		if(!bookingList.isEmpty())
			return bookingList;
		else
			throw new BookingException("Bookings are not found of customer :"+customer.getName());
		
	}

	@Override
	public String deleteBooking(Integer bookingId,String sessionid)throws BookingException {
		
		if(usersessionDao.findBySessionId(sessionid) == null) {
			throw new LoginException("login first !");
		}
		
		Customer customer = customerDao.findById(usersessionDao.findBySessionId(sessionid).getUserid()).get();
		
		if(customer == null) throw new CustomerException("Customer not login yet..");

		Booking booking =  bookingDao.findById(bookingId).orElseThrow(()-> new BookingException("No booking found with bookingId :"+bookingId));
		
//		bookingDao.deleteById(bookingId);
		
		Cab cab = booking.getCab();
		cab.setAvailbilityStatus(false);
		cabDao.save(cab);
		
		
		return "Thank you ,hope you are enjoying our service !";
	}
	
	
}
