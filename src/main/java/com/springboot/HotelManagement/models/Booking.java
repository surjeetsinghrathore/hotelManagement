package com.springboot.HotelManagement.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer bookingid;

	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="user_id") private User user;
	 */

	
	
	
	@OneToOne(mappedBy = "booking" ,cascade = CascadeType.ALL)
	private User user;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "booking_id")
	private List<Rooms> rooms;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Rooms> getRooms() {
		return rooms;
	}

	@Transactional
	public void setRooms(List<Rooms> rooms) {
		this.rooms = rooms;
	}

	public Integer getBookingid() {
		return bookingid;
	}

	public void setBookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}

	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", user=" + user + ", rooms=" + rooms + "]";
	}

}
