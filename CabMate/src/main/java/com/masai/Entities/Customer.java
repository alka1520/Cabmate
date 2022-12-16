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
public class Customer extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userID;
	
//	private Integer bookingid;

	public Customer(Integer userID) {
		super();
		this.userID = userID;
	}

	public Customer() {
		super();
	}

	
}
