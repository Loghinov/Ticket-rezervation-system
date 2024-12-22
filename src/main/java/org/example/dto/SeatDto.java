package org.example.dto;

import org.example.entity.Flight;

public class SeatDto {
    private long seatId;
    private String seatCode;
    private boolean seatAvailable;
    private FlightDto flightDto;

    public SeatDto(){}


    public SeatDto(long seatId, String seatCode, boolean seatAvailable, FlightDto flightDto) {
        this.seatId = seatId;
        this.seatCode = seatCode;
        this.seatAvailable = seatAvailable;
        this.flightDto = flightDto;
    }

    public long getSeatId() {
        return seatId;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }

    public boolean isSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(boolean seatAvailable) {
        this.seatAvailable = seatAvailable;
    }

    public FlightDto getFlightDto() {
        return flightDto;
    }

    public void setFlightDto(FlightDto flightDto) {
        this.flightDto = flightDto;
    }
}
