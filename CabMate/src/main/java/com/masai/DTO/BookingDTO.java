package com.masai.DTO;

import lombok.Data;

@Data
public class BookingDTO {

	private Integer bookingid;
	private String sourceLocation;
	private String destination;
	private String fromDate;
	private String toDate;
	private Double km;
	
}
