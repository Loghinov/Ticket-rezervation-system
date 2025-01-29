package org.example.dto;

public class BookingDto {
    private long bookingId;
    private UserDto userDto;
    private TicketDto ticketDtoTur;
    private TicketDto ticketDtoRetur;

    public BookingDto(){
    }

    public BookingDto(long bookingId, UserDto userDto, TicketDto ticketDtoTur, TicketDto ticketDtoRetur) {
        this.bookingId = bookingId;
        this.userDto = userDto;
        this.ticketDtoTur = ticketDtoTur;
        this.ticketDtoRetur=ticketDtoTur;
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

    public TicketDto getTicketDtoTur() {
        return ticketDtoTur;
    }

    public void setTicketDtoTur(TicketDto ticketDtoTur) {
        this.ticketDtoTur = ticketDtoTur;
    }

    public TicketDto getTicketDtoRetur() {
        return ticketDtoRetur;
    }

    public void setTicketDtoRetur(TicketDto ticketDtoRetur) {
        this.ticketDtoRetur = ticketDtoRetur;
    }
}
