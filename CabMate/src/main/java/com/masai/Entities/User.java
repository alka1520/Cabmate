package com.masai.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	
	private String phone;
	private String password;
	private String address;
	private String name;
	private String email;
	
	
	
	
}