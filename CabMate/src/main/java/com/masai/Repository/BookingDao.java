package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.Entities.Booking;

public interface BookingDao extends JpaRepository<Booking, Integer> {
	
	@Query(value="from booking where cabId=?1")
	public List<Booking> getBookingListByCabid(Integer cabid);

}
