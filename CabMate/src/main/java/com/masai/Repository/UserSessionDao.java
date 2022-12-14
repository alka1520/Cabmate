package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entities.UserSession;

public interface UserSessionDao extends JpaRepository<UserSession, Integer>{

}
