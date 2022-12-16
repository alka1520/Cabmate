package com.masai.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver extends User{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverID;
	
	private String LicenseNo;
	
	private Double rating;
	
	final Integer role=2;

	
	
	
}