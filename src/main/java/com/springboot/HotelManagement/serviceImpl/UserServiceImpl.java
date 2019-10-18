package com.springboot.HotelManagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.HotelManagement.models.User;
import com.springboot.HotelManagement.repositories.UserRepository;
import com.springboot.HotelManagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository managerrepository;

	@Override
	public List<User> getAllVisitor() {

		return managerrepository.findAll();
	}

	@Override
	public User saveVisitor(User theVisitor) {

		return managerrepository.save(theVisitor);
	}

	@Override
	public User getById(Integer id) {

		Optional<User> theVisitor = managerrepository.findById(id);

		return theVisitor.isPresent() ? theVisitor.get() : null;
	}

	@Override
	public List<User> deleteVisitor(Integer id) {

		managerrepository.deleteById(id);

		return managerrepository.findAll();
	}

	@Override
	public User update(User userById) {

		return managerrepository.save(userById);
	}

}
