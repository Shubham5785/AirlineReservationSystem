package com.AirlineReservationSystem.repository;

import com.AirlineReservationSystem.entity.Booking;
import com.AirlineReservationSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
}
