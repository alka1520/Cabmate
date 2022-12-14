package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Entities.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {

}
