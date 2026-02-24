package com.AirlineReservationSystem.controller;

import com.AirlineReservationSystem.entity.Flight;
import com.AirlineReservationSystem.repository.FlightRepository;
import com.AirlineReservationSystem.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public Flight addFlight(@Valid @RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    @GetMapping
    public Page<Flight> getAllFlights(Pageable pageable) {
        return flightService.getAllFlights(pageable);
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable Long id,
                               @Valid @RequestBody Flight flightDetails) {
        return flightService.updateFlight(id, flightDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return "Flight deleted successfully";
    }

    @GetMapping("/search")
    public List<Flight> searchFlights(
            @RequestParam String source,
            @RequestParam String destination) {
        return flightService.searchFlights(source, destination);
    }
}
