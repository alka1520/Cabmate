package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entities.Verification;

public interface VerificationDao extends JpaRepository<Verification, String>{

}
