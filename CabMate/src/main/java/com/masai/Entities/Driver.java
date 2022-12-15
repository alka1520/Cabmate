package com.masai.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Driver extends User{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverID;
	
	private String LicenseNo;
	
	private Double rating;
	

	
	public Integer getDriverID() {
		return driverID;
	}
	public void setDriver_ID(Integer driverID) {
		this.driverID = driverID;
	}
	public String getLicenseNo() {
		return LicenseNo;
	}
	public void setLicense_no(String licenseNo) {
		LicenseNo = licenseNo;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	public Driver(String phone, String password, String address, String name, Integer roll, String email,
			Integer driverID, String licenseNo, Double rating) {
		super(phone, password, address, name, roll, email);
		this.driverID = driverID;
		LicenseNo = licenseNo;
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Driver [driverID=" + driverID + ", LicenseNo=" + LicenseNo + ", rating=" + rating + "]";
	}

	
	
	
}