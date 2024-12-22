package org.example.service;

import org.example.dto.TicketDto;
import org.example.entity.Ticket;


public interface TicketService {
    TicketDto getTicketById(long ticketId);
}
