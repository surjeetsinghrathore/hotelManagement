package com.springboot.HotelManagement.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.HotelManagement.dto.RoomsDTO;
import com.springboot.HotelManagement.mapper.RoomsMapper;
import com.springboot.HotelManagement.models.Rooms;
import com.springboot.HotelManagement.service.RoomsService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/roomscontroller")
public class RoomsController {

	@Autowired
	private RoomsService roomsService;

	@Autowired
	private RoomsMapper roomsMapper;

	// saving rooms

	@PostMapping("/saverooms")
	private RoomsDTO saveRooms(@RequestBody RoomsDTO roomsdto)

	{
		System.out.println(roomsdto.getFacility());
		Rooms theRooms = roomsService.saveRooms(roomsMapper.dtoToEntity(roomsdto));
		// System.out.println(theRooms.getFacility());
		return roomsMapper.entityToDto(theRooms);
	}
	
	

	// list all the rooms

	@GetMapping("/listrooms")
	private List<RoomsDTO> getAllRooms(RoomsDTO roomsdto) {

		return roomsMapper.entityToDtoList(roomsService.getAllRooms());
	}

	// update rooms

	@PostMapping("/updaterooms/{id}")
	private RoomsDTO updateUser(@PathVariable Integer id, @RequestBody RoomsDTO roomsdto) {
		Rooms theRooms = roomsService.getRoomsById(id);
		theRooms.setStatus(roomsdto.getStatus());
		theRooms.setFacility(roomsdto.getFacility());
		return roomsMapper.entityToDto(roomsService.updateRooms(theRooms));

	}

	// get rooms by id

	@GetMapping("/getbyid/{id}")
	private RoomsDTO getUserById(@PathVariable Integer id) {
		Rooms theRooms = roomsService.getRoomsById(id);
		return roomsMapper.entityToDto(theRooms);

	}

	// delete rooms by id

	@DeleteMapping("/deletebyid/{id}")
	private List<RoomsDTO> deleteById(@PathVariable Integer id) {
		roomsService.deleteRoomsById(id);
		return roomsMapper.entityToDtoList(roomsService.getAllRooms());

	}

}
