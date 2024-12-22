package org.example.service.Impl;

import org.example.dao.PaymentDao;
import org.example.dto.BookingDto;
import org.example.dto.PaymentDto;
import org.example.entity.Payment;
import org.example.service.BookingService;
import org.example.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentDao paymentDao;
    private BookingService bookingService;

    public PaymentServiceImpl(PaymentDao paymentDao, BookingService bookingService) {
        this.paymentDao = paymentDao;
        this.bookingService = bookingService;
    }

    @Override

    public PaymentDto getPaymentById(long paymentId){
        Payment payment =paymentDao.getById(paymentId);
        BookingDto bookingDto = bookingService.getBookingById(payment.getBookingId());

        PaymentDto paymentDto = new PaymentDto(payment.getPaymentId(),bookingDto, payment.getFirstName(), payment.getLastName(), payment.getCardId(), payment.getPaymentStatus(), payment.getPaymentDate());
        return paymentDto;
    }
}
