package com.masai.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@NotNull
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number")
	private String phone;
	
	@NotNull
	@Size(min = 8,message="password should be minimum 8 characters")
	private String password;
	
	@NotNull
	private String address;
	
	@NotNull
	private String name;
	
	@NotNull
	@Email
	private String email;
	
	
	
	
}