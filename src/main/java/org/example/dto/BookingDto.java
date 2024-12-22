package org.example.dto;

public class BookingDto {
    private long bookingId;
    private UserDto userDto;
    private TicketDto ticketId;

    public BookingDto(){
    }

    public BookingDto(long bookingId, UserDto userDto, TicketDto ticketId) {
        this.bookingId = bookingId;
        this.userDto = userDto;
        this.ticketId = ticketId;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public UserDto getUserId() {
        return userDto;
    }

    public void setUserId(UserDto userId) {
        this.userDto = userId;
    }

    public TicketDto getTicketId() {
        return ticketId;
    }

    public void setTicketId(TicketDto ticketId) {
        this.ticketId = ticketId;
    }
}
