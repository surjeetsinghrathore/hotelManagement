package com.springboot.HotelManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.HotelManagement.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}