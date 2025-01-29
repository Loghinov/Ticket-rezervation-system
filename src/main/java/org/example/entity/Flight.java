package org.example.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {
    private long flightId;
    private long departureAirportId;
    private long arrivalAirportId;
    private long airlineId;
    private double price;
    private LocalDateTime timeDeparture;
    private LocalDateTime timeArrival;



    public Flight() {};
    public Flight(long flightId, long departureAirportId, long arrivalAirportId, long airlineId, LocalDateTime timeDeparture, LocalDateTime timeArrival, double price) {
        this.flightId = flightId;
        this.departureAirportId = departureAirportId;
        this.arrivalAirportId = arrivalAirportId;
        this.airlineId = airlineId;
        this.timeDeparture = timeDeparture;
        this.timeArrival = timeArrival;
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

    public LocalDateTime getTimeDeparture() {return timeDeparture;}

    public void setTimeDeparture(LocalDateTime timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public LocalDateTime getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(LocalDateTime timeArrival) {
        this.timeArrival = timeArrival;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString(){
        return "FLight id: "+ flightId +" Departure Airport Id: "+departureAirportId+" Arrival Airport Id: "+arrivalAirportId+" Airline id: "+airlineId+" Time departure: "+ timeDeparture +" Time arrival: "+ timeArrival +" Price: "+price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightId == flight.flightId && departureAirportId==flight.departureAirportId && arrivalAirportId==flight.arrivalAirportId&& airlineId==flight.airlineId && price==flight.price && Objects.equals(timeDeparture, flight.timeDeparture) && Objects.equals(timeArrival, flight.timeArrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, departureAirportId, arrivalAirportId,  airlineId, price, timeDeparture, timeArrival);
    }
}
