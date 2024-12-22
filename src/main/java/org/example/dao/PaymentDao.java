package org.example.dao;

import org.example.entity.Payment;

public interface PaymentDao extends Dao<Payment> {
    Payment getByBookingId (long bookingId);
}
