package com.masai.Service.TripBooking;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entities.Booking;
import com.masai.Entities.Cab;
import com.masai.Repository.BookingDao;
import com.masai.Repository.CabDao;
import com.masai.Service.Cab.CabService;

@Service
public class TripBookingImpl implements TripBookingService{

	@Autowired
	private CabDao cabDao;
	
	@Autowired
	private BookingDao bookingDao;
	
	@Override
	public Booking bookTrip(Booking booking) {
		
		
		
		List<Cab> cabList = cabDao.findByAvailbilityStatus(true);
		
		if(cabList.size() != 0) {
			
			//LocalDateTime localDT = LocalDateTime.parse(booking.getFromDate());
			
			//It is tight coupling
			//We will convert it into loose coupling when we conneted to front end
			//only change is assign cab object to argumented cab object

			
			
			//Cab cab = cabList.get(0);
			Cab cab = null;
			
			for(Cab c : cabList) {
				 cab = c;
				break;
			}
			
			
			
			//cab.setAvailbilityStatus(true);
			//cab status updated
			//cabDao.save(cab);
			
			booking.setCab(cab);
			Random random = new Random();
			
			booking.setKm(random.nextDouble(100));
			booking.setBill(booking.getKm() * 10);
			booking.setBookingStatus(true);
			
			System.out.println(booking);
			
			return bookingDao.save(booking);
			
		}else 
			return null;
		
	}

	
	
	
}
