package org.example.service.Impl;

import org.example.dao.BookingDao;
import org.example.dto.BookingDto;
import org.example.dto.TicketDto;
import org.example.dto.UserDto;
import org.example.entity.Booking;
import org.example.entity.Ticket;
import org.example.service.BookingService;
import org.example.service.TicketService;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    private BookingDao bookingDao;
    private UserService userService;
    private TicketService ticketService;


    public BookingServiceImpl(BookingDao bookingDao, UserService userService, TicketService ticketService) {
        this.bookingDao = bookingDao;
        this.userService = userService;
        this.ticketService = ticketService;
    }

    @Override
    public BookingDto getBookingDtoById(long bookingId) {
        Booking booking = bookingDao.getById(bookingId);
        UserDto userDto = userService.getUserById(booking.getUserId());
        TicketDto ticketDtoTur = ticketService.getTicketDtoById(booking.getTicketTurId());
        TicketDto ticketDtoRetur= ticketService.getTicketDtoById(booking.getTicketReturId());

        BookingDto bookingDto = new BookingDto(booking.getBookingId(), userDto, ticketDtoTur,ticketDtoRetur);
        return bookingDto;
    }

    @Override
    public BookingDto addBooling(BookingDto bookingDto) {
        Booking booking =new Booking();
        booking.setUserId(bookingDto.getUserId().getUserId());
        Ticket ticket1 =new Ticket();
        ticket1.setFlyId(bookingDto.getTicketDtoTur().getFlightDto().getId());
        ticket1.setPassengerId(bookingDto.getTicketDtoTur().getPassenger().getPassengerId());
        ticket1.setSeatId(bookingDto.getTicketDtoTur().getSeatDto().getSeatId());
        ticket1 =ticketService.addTicket(ticket1);
        booking.setTicketTurId(ticket1.getTicketId());
        bookingDto.getTicketDtoTur().setTicketId(ticket1.getTicketId());
        Ticket ticket2 =new Ticket();
        ticket2.setSeatId(bookingDto.getTicketDtoRetur().getSeatDto().getSeatId());
        ticket2.setPassengerId(bookingDto.getTicketDtoRetur().getPassenger().getPassengerId());
        ticket2.setFlyId(bookingDto.getTicketDtoRetur().getFlightDto().getId());
        ticket2 =ticketService.addTicket(ticket2);
        booking.setTicketReturId(ticket2.getTicketId());
        bookingDto.getTicketDtoRetur().setTicketId(ticket2.getTicketId());
        booking =bookingDao.save(booking);
        bookingDto.setBookingId(booking.getBookingId());
        return bookingDto ;
    }


}
