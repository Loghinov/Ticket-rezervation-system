package org.example.entity;

public class Seat {
    private long seatId;
    private String seatCode;
    private boolean seatAvailable;
    private long flyId;

    public Seat() {};
    public Seat(long seatId, String seatCode, boolean seatAvailable, long flyId){
        this.seatId = seatId;
        this.seatCode = seatCode;
        this.seatAvailable = seatAvailable;
        this.flyId = flyId;
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

    public long getFlyId() {
        return flyId;
    }

    public void setFlyId(long flyId) {
        this.flyId = flyId;
    }
    @Override
    public String toString() {
        return "Seat id: "+ seatId +"Seat code: "+seatCode+"Seat Available: "+seatAvailable+"Fly id: "+flyId;
    }

}
