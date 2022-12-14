package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Entities.Cab;

@Repository
public interface CabDao extends JpaRepository<Cab, Integer>{

	
	
}
