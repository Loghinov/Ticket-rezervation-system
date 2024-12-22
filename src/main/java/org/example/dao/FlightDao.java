package org.example.dao;

import org.example.entity.Flight;

public interface FlightDao extends Dao<Flight>{
    Flight getByDepartureAirportId(long departureAirportId);
}
