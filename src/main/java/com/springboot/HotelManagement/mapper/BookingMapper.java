package com.springboot.HotelManagement.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.springboot.HotelManagement.dto.BookingDTO;
import com.springboot.HotelManagement.dto.RoomsDTO;
import com.springboot.HotelManagement.models.Booking;
import com.springboot.HotelManagement.models.Rooms;

@Component
public class BookingMapper {

	public Booking dtoToEntity(BookingDTO bookingdto) {

		Booking thebooking = new Booking();
		if (bookingdto != null)
			BeanUtils.copyProperties(bookingdto, thebooking);

		return thebooking;

	}

	public BookingDTO entityToDto(Booking theBooking) {

		BookingDTO bookingdto = new BookingDTO();

		BeanUtils.copyProperties(theBooking, bookingdto);

		return bookingdto;
	}

	public List<BookingDTO> entityToDtoList(List<Booking> theBooking) {
		List<BookingDTO> bookingdto = new ArrayList<BookingDTO>();
		theBooking.forEach((var) -> {

			BookingDTO dto = new BookingDTO();

			BeanUtils.copyProperties(var, dto);

			bookingdto.add(dto);

		});

		return bookingdto;
	}

}