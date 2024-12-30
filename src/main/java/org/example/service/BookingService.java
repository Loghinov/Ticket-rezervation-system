package org.example.service;

import org.example.dto.BookingDto;

public interface BookingService {
    BookingDto getBookingDtoById(long bookingId);
}
