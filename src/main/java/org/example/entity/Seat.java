package org.example.entity;

import java.util.Objects;

public class Seat {
    private long seatId;
    private String seatCode;
    private boolean seatAvailable;
    private long aircraftId;

    public Seat() {};
    public Seat(long seatId, String seatCode, boolean seatAvailable, long aircraftId){
        this.seatId = seatId;
        this.seatCode = seatCode;
        this.seatAvailable = seatAvailable;
        this.aircraftId = aircraftId;
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

    public boolean getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(boolean seatAvailable) {
        this.seatAvailable = seatAvailable;
    }

    public long getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(long aircraftId) {
        this.aircraftId = aircraftId;
    }

    @Override
    public String toString() {
        return "Seat id: "+ seatId +"Seat code: "+seatCode+"Seat Available: "+seatAvailable+"Fly id: "+ aircraftId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return seatId == seat.seatId && seatAvailable == seat.seatAvailable && aircraftId == seat.aircraftId && Objects.equals(seatCode, seat.seatCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatId, seatCode, seatAvailable, aircraftId);
    }

}
