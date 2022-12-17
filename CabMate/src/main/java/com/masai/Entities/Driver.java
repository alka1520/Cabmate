package com.masai.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends User{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverID;
	
	private String LicenseNo;
	
	private Double rating;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cabId")
	private Cab cab;


}