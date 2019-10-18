package com.springboot.HotelManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.HotelManagement.dto.UserDTO;
import com.springboot.HotelManagement.mapper.UserMapper;
import com.springboot.HotelManagement.models.User;
import com.springboot.HotelManagement.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usercontroller")
public class ManagerController {

	@Autowired
	private UserService userservice;

	@Autowired
	private UserMapper usermapper;

	// list users
	@GetMapping("/listuser")
	private List<UserDTO> getAllVisitor() {
		return usermapper.entityToDto(userservice.getAllVisitor());
	}

	// save users
	@PostMapping("/saveuser")
	private UserDTO saveUser(@RequestBody UserDTO userdto) {
		User theUser = userservice.saveVisitor(usermapper.dtoToEntity(userdto));
		System.out.println(theUser.getEmail());
		return usermapper.entityToDtoObj(theUser);
	}

	// update check in checkout mobile number in user
	@PostMapping("/updateuser/{id}")
	private UserDTO update(@PathVariable Integer id, @RequestBody UserDTO userdto) {

		User theUser = usermapper.dtoToEntity(userdto);
		User userById = userservice.getById(id);
		userById.setCheckin(theUser.getCheckin());
		userById.setCheckout(theUser.getCheckout());
		userById.setMobileno(theUser.getMobileno());
		return usermapper.entityToDtoObj(userservice.update(userById));

	}

	@GetMapping("/getbyid/{id}")
	private UserDTO getUserById(@PathVariable Integer id) {
		User theUser = userservice.getById(id);
		return usermapper.entityToDtoObj(theUser);

	}

	@DeleteMapping("/deletebyid/{id}")
	private List<UserDTO> deleteById(@PathVariable Integer id) {
		userservice.deleteVisitor(id);
		return usermapper.entityToDto(userservice.getAllVisitor());

	}

}
