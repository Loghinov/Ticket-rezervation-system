package org.example.dto;

import org.example.entity.Passenger;

public class TicketDto {
    private long ticketId;
    private FlightDto flightDto;
    private Passenger passenger;
    private SeatDto seatDto;


    public TicketDto (){}

    public TicketDto(long ticketId, FlightDto flightDto, Passenger passenger, SeatDto seatDto) {
        this.ticketId = ticketId;
        this.flightDto = flightDto;
        this.passenger = passenger;
        this.seatDto = seatDto;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public FlightDto getFlightDto() {
        return flightDto;
    }

    public void setFlightDto(FlightDto flightDto) {
        this.flightDto = flightDto;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public SeatDto getSeatDto() {
        return seatDto;
    }

    public void setSeatDto(SeatDto seatDto) {
        this.seatDto = seatDto;
    }
}
