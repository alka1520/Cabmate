package com.masai.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.Entities.Booking;
import com.masai.Entities.Cab;
import com.masai.Entities.Customer;

public interface BookingDao extends JpaRepository<Booking, Integer> {
	
	public List<Booking> findByCustomer(Customer customer);
	
	public List<Booking> findByBookingStatus(Boolean bookingStatus);
	
	public List<Booking> findByCab(Cab cab);
	
	@Query("from Booking where from_date=?1")
	public List<Booking> getBookingsByDate(LocalDate date,String sessionid);
	
	@Query(value = "from Booking where from_date BETWEEN ?1 AND ?2")
	public List<Booking> getBookingsByDateSpan(LocalDate startdate,LocalDate enddate,String sessionid);

}
