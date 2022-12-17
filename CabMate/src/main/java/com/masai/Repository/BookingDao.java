package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entities.Booking;
import com.masai.Entities.Customer;

public interface BookingDao extends JpaRepository<Booking, Integer> {
	
	public List<Booking> findByCustomer(Customer customer);
	
}
