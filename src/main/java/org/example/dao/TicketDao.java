package org.example.dao;

import org.example.entity.Ticket;

public interface TicketDao extends Dao<Ticket> {
    Ticket getByPassengerId (long passengerId);
}
