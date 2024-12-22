package org.example.entity;

import java.time.LocalDateTime;

public class Flight {
    private long flightId;
    private long departureAirportId;
    private long arrivalAirportId;
    private long airlineId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private double price;


    public Flight() {};
    public Flight(long flightId, long departureAirportId, long arrivalAirportId, long airlineId, LocalDateTime DepartureTime, LocalDateTime ArrivalTime, double price) {
        this.flightId = flightId;
        this.departureAirportId = departureAirportId;
        this.arrivalAirportId = arrivalAirportId;
        this.airlineId = airlineId;
        this.departureTime = DepartureTime;
        this.arrivalTime = ArrivalTime;
        this.price = price;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public long getDepartureAirportId() {
        return departureAirportId;
    }

    public void setDepartureAirportId(long departureAirportId) {
        this.departureAirportId = departureAirportId;
    }

    public long getArrivalAirportId() {
        return arrivalAirportId;
    }

    public void setArrivalAirportId(long arrivalAirportId) {
        this.arrivalAirportId = arrivalAirportId;
    }

    public long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(long airlineId) {
        this.airlineId = airlineId;
    }

    public LocalDateTime getDepartureTime() {return departureTime;}

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
    @Override
    public String toString(){
        return "FLight id: "+ flightId +" Departure Airport Id: "+departureAirportId+" Arrival Airport Id: "+arrivalAirportId+" Airline id: "+airlineId+" Time departure: "+ departureTime +" Time arrival: "+ arrivalTime +" Price: "+price;
    }
}
