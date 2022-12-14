package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entities.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
