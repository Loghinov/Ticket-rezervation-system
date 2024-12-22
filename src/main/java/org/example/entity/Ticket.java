package org.example.entity;

public class Ticket {
    private long ticketId;
    private long flyId;
    private long passengerId;
    private long seatId;

    public Ticket() {};
    public Ticket(long ticketId, long flyId, long passengerId, long seatId){
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

    public long getFlyId() {
        return flyId;
    }

    public void setFlyId(long flyId) {
        this.flyId = flyId;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    public long getSeatId() {
        return seatId;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
    }
    @Override
    public String toString(){
        return "Fly id: "+ ticketId +"Fly id tur: "+ flyId+" Person id: "+ passengerId +" Seat id: "+seatId;
    }
}
