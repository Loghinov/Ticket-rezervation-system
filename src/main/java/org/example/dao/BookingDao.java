package org.example.dao;

import org.example.entity.Booking;

public interface BookingDao extends Dao<Booking> {
    Booking getByUserId (long userId);
}
