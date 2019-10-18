package com.springboot.HotelManagement.service;

import java.util.List;

import com.springboot.HotelManagement.models.User;

public interface UserService {
	
	public List<User> getAllVisitor();
	public   User saveVisitor(User theVisitor);
	
	public User getById(Integer id);
	public  List<User> deleteVisitor(Integer id);
	public User update(User userById);
	

}
