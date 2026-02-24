package com.AirlineReservationSystem.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {

    private Long bookingId;
    private String userName;
    private String flightNumber;
    private String source;
    private String destination;
    private String bookingTime;
}

