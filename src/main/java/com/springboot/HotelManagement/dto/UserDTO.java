package com.springboot.HotelManagement.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.springboot.HotelManagement.models.Booking;
import com.springboot.HotelManagement.models.Roles;


public class UserDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String name;

	private String email;

	private Long mobileno;


	private Date checkin;

	
	private Date checkout;

	
	private Roles role;
	
	
	private Booking  booking;
	


	

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileno() {
		return mobileno;
	}

	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}


}
