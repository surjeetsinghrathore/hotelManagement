package com.springboot.HotelManagement.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.springboot.HotelManagement.dto.RoomsDTO;
import com.springboot.HotelManagement.dto.UserDTO;
import com.springboot.HotelManagement.models.Rooms;
import com.springboot.HotelManagement.models.User;

@Component
public class RoomsMapper {

	public Rooms dtoToEntity(RoomsDTO roomsdto) {

		Rooms theRooms = new Rooms();
		if (roomsdto != null)
			BeanUtils.copyProperties(roomsdto, theRooms);

		return theRooms;

	}

	public RoomsDTO entityToDto(Rooms theRooms) {

		RoomsDTO roomsdto = new RoomsDTO();

		BeanUtils.copyProperties(theRooms, roomsdto);

		return roomsdto;
	}

	public List<RoomsDTO> entityToDtoList(List<Rooms> theRooms) {
		List<RoomsDTO> roomsdto = new ArrayList<RoomsDTO>();
		theRooms.forEach((var) -> {

			RoomsDTO dto = new RoomsDTO();

			BeanUtils.copyProperties(var, dto);

			roomsdto.add(dto);

		});

		return roomsdto;
	}

}
