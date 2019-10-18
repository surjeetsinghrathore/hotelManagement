package com.springboot.HotelManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.HotelManagement.models.Rooms;
import com.springboot.HotelManagement.repositories.RoomsRepository;
import com.springboot.HotelManagement.service.RoomsService;

@Service
public class RoomsServiceImpl implements RoomsService {

	@Autowired
	private RoomsRepository roomsrepositry;

	@Override
	public List<Rooms> getAllRooms() {

		return roomsrepositry.findAll();
	}

	@Override
	public Rooms saveRooms(Rooms theRooms) {

		return roomsrepositry.save(theRooms);
	}

	@Override
	public Rooms updateRooms(Rooms theRooms) {

		return roomsrepositry.save(theRooms);

	}

	@Override
	public Rooms getRoomsById(Integer id) {

		Optional<Rooms> theRooms = roomsrepositry.findById(id);
		return theRooms.isPresent() ? theRooms.get() : null;

	}

	@Override
	public List<Rooms> deleteRoomsById(Integer id) {

		roomsrepositry.deleteById(id);
		return roomsrepositry.findAll();
	}

}
