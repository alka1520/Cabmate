package com.masai.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.Entities.Booking;

public interface BookingDao extends JpaRepository<Booking, Integer> {


	@Query("from Booking where fromdate=?1")
	public List<Booking> getBookingsByDate(LocalDate date,String sessionid);
	
	@Query(value = "from Booking b where fromdate BETWEEN ?1 AND ?2")
	public List<Booking> getBookingsByDateSpan(LocalDate startdate,LocalDate enddate,String sessionid);
}
