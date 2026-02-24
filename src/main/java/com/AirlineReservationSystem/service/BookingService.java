package com.AirlineReservationSystem.service;

import com.AirlineReservationSystem.dto.BookingResponse;
import com.AirlineReservationSystem.entity.Booking;
import com.AirlineReservationSystem.entity.Flight;
import com.AirlineReservationSystem.entity.User;
import com.AirlineReservationSystem.repository.BookingRepository;
import com.AirlineReservationSystem.repository.FlightRepository;
import com.AirlineReservationSystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;

    public BookingService(UserRepository userRepository,
                          BookingRepository bookingRepository,
                          FlightRepository flightRepository) {
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.flightRepository = flightRepository;
    }
    @Transactional
    public BookingResponse bookFlight(Long flightId, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        if (flight.getAvailableSeats() <= 0) {
            throw new RuntimeException("No seats available");
        }

        flight.setAvailableSeats(flight.getAvailableSeats() - 1);
        flightRepository.save(flight);

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setFlight(flight);
        booking.setBookingTime(LocalDateTime.now());

        Booking savedBooking = bookingRepository.save(booking);

        return new BookingResponse(
                savedBooking.getId(),
                savedBooking.getUser().getName(),
                savedBooking.getFlight().getFlightNumber(),
                savedBooking.getFlight().getSource(),
                savedBooking.getFlight().getDestination(),
                savedBooking.getBookingTime().toString()
        );
    }

    public List<BookingResponse> getBookingsByUser(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return bookingRepository.findByUser(user)
                .stream()
                .map(booking -> new BookingResponse(
                        booking.getId(),
                        booking.getUser().getName(),
                        booking.getFlight().getFlightNumber(),
                        booking.getFlight().getSource(),
                        booking.getFlight().getDestination(),
                        booking.getBookingTime().toString()
                ))
                .toList();
    }

    @Transactional
    public String cancelBooking(Long bookingId, String email) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (!booking.getUser().getEmail().equals(email)) {
            throw new RuntimeException("You are not allowed to cancel this booking");
        }

        Flight flight = booking.getFlight();
        flight.setAvailableSeats(flight.getAvailableSeats() + 1);
        flightRepository.save(flight);

        bookingRepository.delete(booking);

        return "Booking cancelled successfully";
    }
}