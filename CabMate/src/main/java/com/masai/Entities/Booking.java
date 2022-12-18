package com.masai.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GeneratorType;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingid;

	@NotNull
	private String sourceLocation;
	
	@NotNull
	private String destination;
	
	@NotNull
	private LocalDate fromDate;
	
	@NotNull
	private LocalDate toDate;
	
	@NotNull
	private Double bill;
	private Double km;
	private Boolean bookingStatus=false;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cabId") 
	@JsonIgnore
	private Cab cab;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId") 
	private Customer customer;
	
 

	
}
