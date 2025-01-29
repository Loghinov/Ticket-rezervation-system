package org.example.service.Impl;

import org.example.dao.FlightDao;
import org.example.dto.FlightDto;

import org.example.entity.Airline;
import org.example.entity.Airport;
import org.example.entity.Flight;
import org.example.service.AirlineService;
import org.example.service.AirportService;
import org.example.service.FlightService;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {
    private FlightDao flightDao;
    private AirportService airportService;
    private AirlineService airlineService;



    public FlightServiceImpl(FlightDao flightDao, AirportService airportService, AirlineService airlineService) {
        this.flightDao = flightDao;
        this.airportService = airportService;
        this.airlineService = airlineService;
    }

    @Override
    public FlightDto getFlightById(long flightId){
        Flight flight = flightDao.getById(flightId);
        Airport departureAirport = airportService.getAirportById(flight.getDepartureAirportId());
        Airport arrivalAirport = airportService.getAirportById(flight.getArrivalAirportId());
        Airline airline = airlineService.getAirlineById(flight.getAirlineId());

        FlightDto flightDto = new FlightDto(flight.getFlightId(), departureAirport, arrivalAirport, flight.getTimeDeparture(), flight.getTimeArrival(), flight.getPrice(), airline);
        return flightDto;
    }
}
