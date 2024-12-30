package org.example.service.Impl;

import org.example.dao.TicketDao;
import org.example.dto.FlightDto;
import org.example.dto.SeatDto;
import org.example.dto.TicketDto;
import org.example.entity.Passenger;
import org.example.entity.Ticket;
import org.example.service.FlightService;
import org.example.service.PassengerService;
import org.example.service.SeatService;
import org.example.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    private TicketDao ticketDao;
    private FlightService flightService;
    private PassengerService passengerService;
    private SeatService seatService;

    public TicketServiceImpl(TicketDao ticketDao, FlightService flightService, PassengerService passengerService, SeatService seatService) {
        this.ticketDao = ticketDao;
        this.flightService = flightService;
        this.passengerService = passengerService;
        this.seatService = seatService;
    }

    @Override
    public TicketDto getTicketDtoById(long ticketId) {
        Ticket ticket = ticketDao.getById(ticketId);
        FlightDto flyId= flightService.getFlightById(ticket.getFlyId());
        Passenger passenger = passengerService.getPassengerById(ticket.getPassengerId());
        SeatDto seatDto = seatService.getSeatById(ticket.getSeatId());

        TicketDto ticketDto = new TicketDto(ticket.getTicketId(), flyId,passenger,seatDto);
        return ticketDto;
    }
}
