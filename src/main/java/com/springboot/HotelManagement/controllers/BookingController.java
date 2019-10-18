package com.springboot.HotelManagement.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.HotelManagement.dto.BookingDTO;
import com.springboot.HotelManagement.dto.RoomsDTO;
import com.springboot.HotelManagement.mapper.BookingMapper;
import com.springboot.HotelManagement.mapper.JsonHelperObject;
import com.springboot.HotelManagement.mapper.RoomsMapper;
import com.springboot.HotelManagement.models.Booking;
import com.springboot.HotelManagement.models.Rooms;
import com.springboot.HotelManagement.models.User;
import com.springboot.HotelManagement.service.BookingService;
import com.springboot.HotelManagement.service.RoomsService;
import com.springboot.HotelManagement.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bookingcontroller")
public class BookingController {

	@Autowired
	BookingMapper bookingmapper;

	@Autowired
	RoomsMapper roomsmapper;

	@Autowired
	BookingService bookingservice;

	@Autowired
	UserService userService;

	@Autowired
	RoomsService roomsservice;

	@Autowired
	private JavaMailSender javaMailSender;

	@PostMapping(value = "/booking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<JsonHelperObject> roombook(@RequestBody BookingDTO bookingdto) {

		HttpStatus status = HttpStatus.OK;
		JsonHelperObject body = new JsonHelperObject(true, "Room Alerady Allocated");
		// convert bookingdto object from dto to entity
		Booking theBooking = bookingmapper.dtoToEntity(bookingdto);

		// get user id from booking object and get user object from that id.
		User user = userService.getById(theBooking.getUser().getId());

		// set user object to the booking object
		theBooking.setUser(user);

		// get rooms List from booking obj
		List<Rooms> rooms = theBooking.getRooms();

		// get rooms from rooms list and get each room id check for rooms status
		for (Rooms rooms2 : rooms) {
			Integer id = rooms2.getId();
			Rooms roomsbyid = roomsservice.getRoomsById(id);
			if (roomsbyid.getStatus().equals("false")) {
				return new ResponseEntity<>(body, status);
			}
		}

		// create empty list
		List<Rooms> roomsList = new ArrayList<Rooms>();

		// fetch rooms from roomsList and set status to false
		rooms.forEach(temp -> {
			Rooms rooms1 = roomsservice.getRoomsById(temp.getId());
			rooms1.setStatus("false");
			roomsList.add(rooms1);
		});
		// set rooms field same as database and change status to false in booking obj
		theBooking.setRooms(roomsList);

		// save booking obj
		Booking booking = bookingservice.saveBooking(theBooking);

		// get user
		User user2 = booking.getUser();

		// set booking obj to user
		user2.setBooking(booking);

		// save user
		User user1 = userService.saveVisitor(theBooking.getUser());

		// set user to booking
		booking.setUser(user1);
		if (booking != null) {

			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(booking.getUser().getEmail());

			msg.setSubject("Room Booked Successfully");
			msg.setText("Hello " + booking.getUser().getName() + "\n Your Room is booked");

			javaMailSender.send(msg);

		}
		if (booking != null) {
			body = new JsonHelperObject(false, "Room Booking succesfully", booking);
		}

		return new ResponseEntity<>(body, status);

	}

	// list booking

	@GetMapping("/listbooking")
	private List<BookingDTO> getAllBooking() {

		return bookingmapper.entityToDtoList(bookingservice.getAllBooking());
	}

	// get booking by id

	@GetMapping("/getbyid/{id}")
	private BookingDTO getBookingById(@PathVariable Integer id) {

		Booking theBooking = bookingservice.getBookingById(id);

		return bookingmapper.entityToDto(theBooking);
	}

	@PostMapping("/addmorerooms/{id}")
	private BookingDTO addMoreRooms(@PathVariable Integer id, @RequestBody RoomsDTO roomsdto) {
			
		//booking id and rooms object is recieved 
		//get room by id which is given  by user
		Rooms room = roomsservice.getRoomsById(roomsdto.getId());
		
		//is room is already booked return 
		if (room.getStatus().equals("false")) {
			return null;
		}
		room.setStatus("false");
		
		//get booking obj from given id
		Booking theBooking = bookingservice.getBookingById(id);
		
		//get rooms List from booking obj
		List<Rooms> rooms = theBooking.getRooms();
		
		//add room to rooms list
		rooms.add(room);
		
		//set rooms to booking obj
		theBooking.setRooms(rooms);
		
		//return booking obj
		return bookingmapper.entityToDto(bookingservice.saveBooking(theBooking));
	}

	// update rooms status when room is booked
	@PostMapping("/updatebooking/{id}")
	private BookingDTO updateById(@PathVariable Integer id) {

		Booking theBooking = bookingservice.getBookingById(id);

		List<Rooms> theRoomsList = theBooking.getRooms();

		theRoomsList.forEach((var) -> {
			var.setStatus("false");

		});
		theBooking.setRooms(theRoomsList);
		return bookingmapper.entityToDto(bookingservice.saveBooking(theBooking));
	}

	// delete by booking id

	@DeleteMapping("/deletebyidbooking/{bookingid}")
	private void deleteById(@PathVariable Integer bookingid) {

		bookingservice.deleteByIdBooking(bookingid);

	}

}