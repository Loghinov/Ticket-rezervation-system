package org.example.service;

import org.example.dto.TicketDto;
import org.example.entity.Ticket;


public interface TicketService {
    TicketDto getTicketDtoById(long ticketId);
    Ticket addTicket(Ticket ticket);
}
