package com.AirlineReservationSystem.controller;

import com.AirlineReservationSystem.entity.Booking;
import com.AirlineReservationSystem.dto.BookingResponse;
import com.AirlineReservationSystem.service.BookingService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.AirlineReservationSystem.entity.Booking;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/{flightId}")
    public BookingResponse bookFlight(@PathVariable Long flightId,
                              Authentication authentication) {

        String userEmail = authentication.getName();
        return bookingService.bookFlight(flightId, userEmail);
    }

    @GetMapping
    public List<BookingResponse> getMyBookings(Authentication authentication) {

        String userEmail = authentication.getName();
        return bookingService.getBookingsByUser(userEmail);
    }

    @DeleteMapping("/{bookingId}")
    public String cancelBooking(@PathVariable Long bookingId,
                                Authentication authentication) {

        String userEmail = authentication.getName();
        return bookingService.cancelBooking(bookingId, userEmail);
    }
}
