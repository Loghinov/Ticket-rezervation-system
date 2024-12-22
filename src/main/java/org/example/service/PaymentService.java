package org.example.service;

import org.example.dto.PaymentDto;

public interface PaymentService {
    PaymentDto getPaymentById(long paymentId);

}
