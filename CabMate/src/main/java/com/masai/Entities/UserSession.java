package com.masai.Entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UserSession {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer session_id;
	private Integer user_id;
	private LocalDateTime session_time;
	private Integer role;

}
