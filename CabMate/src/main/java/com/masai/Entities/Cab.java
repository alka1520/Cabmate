package com.masai.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cab {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cabId;
	
	private Double rate;
	
	@NotNull
	private String cartype;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}", message = "Enter valid Vehicle number in proper formate(AB11AB1111)")
	private String cabNumber;
	
	
	private Boolean availbilityStatus;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="driverID")
	@JsonIgnore
	private Driver driver;
	
}