package com.masai.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
	
	@Id
	private String phone_number;
	private String password;
	private String address;
	private String name;
	private Integer Roll;
	private String email;
	
}