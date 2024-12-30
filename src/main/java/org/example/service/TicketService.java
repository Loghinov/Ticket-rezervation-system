package org.example.service;

import org.example.dto.TicketDto;


public interface TicketService {
    TicketDto getTicketDtoById(long ticketId);
}
