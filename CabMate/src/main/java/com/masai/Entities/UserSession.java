package com.masai.Entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSession {
	
	
//	@GeneratedValue(strategy =GenerationType.AUTO)
	@Id
	private Integer userid;
	private String sessionId;

	private LocalDateTime sessiontime;
	private Integer role;
	

}