package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Entities.UserSession;

@Repository
public interface UserSessionDao extends JpaRepository<UserSession, Integer>{

	
	public UserSession findBySessionId(String id);
	
}
