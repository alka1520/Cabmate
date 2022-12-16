package com.masai.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingid;
	
	private String sourcelocation;
	
	private String destination;
	
	private LocalDateTime fromdate;
	private LocalDateTime todate;
	private Double bill;
	private Double km;
	private Boolean status;

	
}
