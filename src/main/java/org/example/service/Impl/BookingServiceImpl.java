package org.example.service.Impl;

import org.example.dao.BookingDao;
import org.example.dto.BookingDto;
import org.example.dto.TicketDto;
import org.example.dto.UserDto;
import org.example.entity.Booking;
import org.example.entity.Ticket;
import org.example.entity.User;
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
    public BookingDto getBookingById(long bookingId) {
        Booking booking = bookingDao.getById(bookingId);
        UserDto userDto = userService.getUserById(booking.getUserId());
        TicketDto ticketById = ticketService.getTicketById(booking.getTicketTurId());
        BookingDto bookingDto = new BookingDto(booking.getBookingId(), userDto, ticketById);
        return bookingDto;
    }
}
