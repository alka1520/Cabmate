package com.masai.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;

	final Integer role = 1;
	

}
