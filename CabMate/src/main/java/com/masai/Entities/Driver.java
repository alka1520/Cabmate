package com.masai.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Driver {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverID;
	private String LicenseNo;
	private Double rating;
	
}
