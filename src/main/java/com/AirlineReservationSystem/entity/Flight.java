package com.AirlineReservationSystem.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;
import jakarta.persistence.Version;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Flight number cannot be empty")
    private String flightNumber;

    @NotBlank(message = "Source cannot be empty")
    private String source;

    @NotBlank(message = "Destination cannot be empty")
    private String destination;

    @NotBlank(message = "Departure time cannot be empty")
    private String departureTime;

    @Positive(message = "Price must be greater than 0")
    private double price;

    @Min(value = 1, message = "Available seats must be at least 1")
    private int availableSeats;

    @Version
    private Integer version;
}

