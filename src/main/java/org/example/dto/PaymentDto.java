package org.example.dto;

import java.time.LocalDateTime;

public class PaymentDto {
    private long paymentId;
    private BookingDto bookingId;
    private String firstName;
    private String lastName;
    private long cardId;
    private String paymentStatus;
    private LocalDateTime paymentDate;

    public PaymentDto(){}

    public PaymentDto(long paymentId, BookingDto bookingId, String firstName, String lastName, long cardId, String paymentStatus, LocalDateTime paymentDate) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardId = cardId;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public BookingDto getBookingId() {
        return bookingId;
    }

    public void setBookingId(BookingDto bookingId) {
        this.bookingId = bookingId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}
