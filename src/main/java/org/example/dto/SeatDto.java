package org.example.dto;

import org.example.entity.Aircraft;

public class SeatDto {
    private long seatId;
    private String seatCode;
    private boolean seatAvailable;
    private Aircraft aircraft;

    public SeatDto(){}


    public SeatDto(long seatId, String seatCode, boolean seatAvailable, Aircraft aircraft) {
        this.seatId = seatId;
        this.seatCode = seatCode;
        this.seatAvailable = seatAvailable;
        this.aircraft = aircraft;
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

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}
