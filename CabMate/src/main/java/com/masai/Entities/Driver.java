package com.masai.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Driver extends User{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverID;
	
	@NotNull
	@Pattern(regexp = "[A-Z || a-z]{2}[0-9]{13}", message = "Enter valid License number")
	private String LicenseNo;
	
	@Max(value=5)
	@Min(value=0)
	private Double rating;
	
	private Boolean approvalStatus=false;
	
	final Integer role=2;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cabId")
	private Cab cab;



}