package org.example.service;

import org.example.dto.FlightDto;
import org.example.entity.Flight;

public interface FlightService {
    FlightDto getFlightById(long flightId);

}
