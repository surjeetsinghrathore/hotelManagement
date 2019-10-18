package com.springboot.HotelManagement.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.springboot.HotelManagement.dto.UserDTO;
import com.springboot.HotelManagement.models.User;

@Component
public class UserMapper {

	public List<UserDTO> entityToDto(List<User> userlist) {

		List<UserDTO> userdto = new ArrayList<UserDTO>();

		userlist.forEach((var) -> {
			UserDTO udto = new UserDTO();
			BeanUtils.copyProperties(var, udto);
			userdto.add(udto);
		});

		return userdto;
	}

	public User dtoToEntity(UserDTO userdto) {
		User user = new User();

		BeanUtils.copyProperties(userdto, user);

		return user;

	}

	public UserDTO entityToDtoObj(User theUser) {

		UserDTO userdto = new UserDTO();

		BeanUtils.copyProperties(theUser, userdto);

		return userdto;
	}

}
