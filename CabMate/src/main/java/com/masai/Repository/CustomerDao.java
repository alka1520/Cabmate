package com.masai.Repository;

import javax.validation.constraints.Positive;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.Entities.Customer;
import com.masai.Entities.User;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

	public Customer findByPhone(String phone);


}
