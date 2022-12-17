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

import org.hibernate.annotations.GeneratorType;

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

	private String sourceLocation;
	private String destination;
	private String fromDate;
	private String toDate;
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
	
*/	 

	
}
