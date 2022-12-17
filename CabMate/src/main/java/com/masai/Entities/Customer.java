package com.masai.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Customer extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerID;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	@JsonIgnore
	List<Booking> bookingList = new ArrayList<>();

	/*
	 * public Customer(Integer userID) { super(); this.userID = userID; }
	 * 
	 * public Customer() { super(); }
	 */
	
}
