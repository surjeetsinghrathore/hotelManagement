package com.springboot.HotelManagement.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.HotelManagement.models.Booking;
import com.springboot.HotelManagement.repositories.BookingRepository;
import com.springboot.HotelManagement.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingrepository;

	@Override
	public Booking saveBooking(Booking theBooking) {

		return bookingrepository.save(theBooking);
	}

	
	  @Override public void deleteByIdBooking(Integer bookingid) {
	  
	  bookingrepository.deleteById(bookingid);
	  
	  }
	  
	 

	@Override
	public List<Booking> getAllBooking() {

		return bookingrepository.findAll();
	}

	@Override
	public Booking getBookingById(Integer id) {

		Optional<Booking> theBooking = bookingrepository.findById(id);

		return theBooking.isPresent() ? theBooking.get() : null;
	}

}