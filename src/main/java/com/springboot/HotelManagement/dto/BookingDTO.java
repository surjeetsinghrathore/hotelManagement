package com.springboot.HotelManagement.dto;

import java.util.List;

import com.springboot.HotelManagement.models.Rooms;
import com.springboot.HotelManagement.models.User;

public class BookingDTO {

	private Integer bookingid;

	private User user;

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

	public void setRooms(List<Rooms> rooms) {
		this.rooms = rooms;
	}

	public Integer getBookingid() {
		return bookingid;
	}

	public void setBookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}

}
