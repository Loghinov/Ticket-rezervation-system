package org.example.dto;

import org.example.entity.Passenger;

public class TicketDto {
    private long ticketId;
    private FlightDto flyId;
    private Passenger passengerId;
    private SeatDto seatId;


    public TicketDto (){}

    public TicketDto(long ticketId, FlightDto flyId, Passenger passengerId, SeatDto seatId) {
        this.ticketId = ticketId;
        this.flyId = flyId;
        this.passengerId = passengerId;
        this.seatId = seatId;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public FlightDto getFlyId() {
        return flyId;
    }

    public void setFlyId(FlightDto flyId) {
        this.flyId = flyId;
    }

    public Passenger getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Passenger passengerId) {
        this.passengerId = passengerId;
    }

    public SeatDto getSeatId() {
        return seatId;
    }

    public void setSeatId(SeatDto seatId) {
        this.seatId = seatId;
    }
}
