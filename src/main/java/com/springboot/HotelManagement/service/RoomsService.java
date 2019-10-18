package com.springboot.HotelManagement.service;

import java.util.List;

import com.springboot.HotelManagement.models.Rooms;

public interface RoomsService {

	public List<Rooms> getAllRooms();

	public Rooms saveRooms(Rooms theRooms);

	public Rooms updateRooms(Rooms theRooms);

	public Rooms getRoomsById(Integer id);

	public List<Rooms> deleteRoomsById(Integer id);

}
