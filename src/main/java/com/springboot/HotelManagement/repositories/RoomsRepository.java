package com.springboot.HotelManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.HotelManagement.models.Rooms;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Integer> {

}
