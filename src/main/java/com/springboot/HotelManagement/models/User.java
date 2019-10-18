package com.springboot.HotelManagement.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "visitor")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String email;

	private Long mobileno;

	@Type(type = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkin;

	@Type(type = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkout;

	@Enumerated(EnumType.STRING)
	private Roles role;

	/*
	 * @OneToOne(mappedBy = "user") private Booking booking;
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "booking_id")
	@JsonIgnore
	private Booking booking;

	
	
	
	
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

	public User() {

	}

	public User(String name, String email, Long mobileno, Date checkin, Date checkout, Roles role, Booking booking) {

		this.name = name;
		this.email = email;
		this.mobileno = mobileno;
		this.checkin = checkin;
		this.checkout = checkout;
		this.role = role;
		this.booking = booking;
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
