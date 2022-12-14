package com.masai.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer admin_Id;

}
