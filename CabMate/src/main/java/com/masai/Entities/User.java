package com.masai.Entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class User {
	
	@Column(unique = true)
	private String phone;
	private String password;
	private String address;
	private String name;
//	private Integer Roll;
	private String email;
	

	
}