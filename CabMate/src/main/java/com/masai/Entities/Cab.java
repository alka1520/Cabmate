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
public class Cab {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cabID;
	private Double rate;
	private String cartype;
	private String cabNumber;
	private Boolean availbilityStatus;
	
	//cab book status
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="driverID")
	@JsonIgnore
	private Driver driver;
	

}
