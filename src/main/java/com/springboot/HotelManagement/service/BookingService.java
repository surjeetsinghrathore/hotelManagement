package com.springboot.HotelManagement.service;

import java.util.List;
import java.util.Optional;

import com.springboot.HotelManagement.models.Booking;

public interface BookingService {

	public Booking saveBooking(Booking theBooking);

	public Booking getBookingById(Integer id);

	 public void deleteByIdBooking(Integer bookingid);

	public List<Booking> getAllBooking();

}