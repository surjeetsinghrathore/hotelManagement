package com.springboot.HotelManagement.dto;

import javax.persistence.ManyToOne;

import com.springboot.HotelManagement.models.Booking;


public class RoomsDTO {
	
	
private Integer id;
	

	
	private String status;
	
	private String facility;
	
	private Booking booking;

public RoomsDTO() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}


	public Booking getBooking() {
		return booking;
	}


	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	

	
}
