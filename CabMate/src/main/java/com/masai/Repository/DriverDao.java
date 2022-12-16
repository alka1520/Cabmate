package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Entities.Driver;

@Repository
public interface DriverDao extends JpaRepository<Driver, Integer>{

	public Driver findByPhone(String phone);
	
}
