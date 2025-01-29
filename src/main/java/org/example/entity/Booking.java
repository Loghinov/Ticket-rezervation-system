package org.example.entity;

import java.util.Objects;

public class Booking {
    private long bookingId;
    private long userId;
    private long ticketTurId;
    private long ticketReturId;

    public Booking() {};
    public Booking(long bookingId, long userId, long ticketTurId, long ticketReturId){
        this.bookingId = bookingId;
        this.userId = userId;
        this.ticketTurId = ticketTurId;
        this.ticketReturId = ticketReturId;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTicketTurId() {
        return ticketTurId;
    }

    public void setTicketTurId(long ticketTurId) {
        this.ticketTurId = ticketTurId;
    }

    public long getTicketReturId() {
        return ticketReturId;
    }

    public void setTicketReturId(long ticketReturId) {
        this.ticketReturId = ticketReturId;
    }

    @Override
    public String toString(){
        return " Booking id: "+ bookingId +" User id: "+userId+" Ticked tur id: "+ ticketTurId +" Ticked Retur id: "+ ticketReturId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking= (Booking) o;
        return bookingId==booking.bookingId && userId==booking.userId && ticketTurId==booking.ticketTurId && ticketReturId==booking.ticketReturId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, userId, ticketTurId, ticketReturId);
    }
}
