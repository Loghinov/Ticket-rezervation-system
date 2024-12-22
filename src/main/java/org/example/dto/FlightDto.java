package org.example.dto;

import org.example.entity.Airline;
import org.example.entity.Airport;

import java.time.LocalDateTime;

public class FlightDto {
    private long id;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private double price;
    private Airline airline;


    public FlightDto (){

    }

    public FlightDto(long id, Airport departureAirport, Airport arrivalAirport,  LocalDateTime departureTime, LocalDateTime arrivalTime, double price, Airline airline) {
        this.id = id;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.airline= airline;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirportId(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirportId() {
        return arrivalAirport;
    }

    public void setArrivalAirportId(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
