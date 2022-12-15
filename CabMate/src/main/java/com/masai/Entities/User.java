package com.masai.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@MappedSuperclass
public class User {
	
	
	private String phone;
	private String password;
	private String address;
	private String name;
	private Integer Roll;
	private String email;
	
	public User() {
		super();
	}

	public User(String phone, String password, String address, String name, Integer roll, String email) {
		super();
		this.phone = phone;
		this.password = password;
		this.address = address;
		this.name = name;
		Roll = roll;
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRoll() {
		return Roll;
	}

	public void setRoll(Integer roll) {
		Roll = roll;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [phone=" + phone + ", password=" + password + ", address=" + address + ", name=" + name + ", Roll="
				+ Roll + ", email=" + email + "]";
	}

	
	
}