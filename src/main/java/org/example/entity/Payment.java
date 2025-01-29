package org.example.entity;


import java.time.LocalDateTime;
import java.util.Objects;

public class Payment {
    private long paymentId;
    private long bookingId;
    private String firstName;
    private String lastName;
    private long cardId;
    private String paymentStatus;
    private LocalDateTime paymentDate;

    public Payment() {};
    public Payment(long paymentId, long bookingId, String firstName, String lastName, long cardId, String paymentStatus, LocalDateTime paymentDate) {
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

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
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

    @Override
    public String toString() {
        return "Payment id: "+ paymentId +" Booking id: "+bookingId+" First name: "+firstName+" Last name: "+lastName+" Card id: "+cardId+" Payment status: "+paymentStatus+" Payment date: "+paymentDate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return paymentId== payment.paymentId && bookingId == payment.bookingId && cardId == payment.cardId && Objects.equals(firstName, payment.firstName) && Objects.equals(lastName, payment.lastName)&& Objects.equals(paymentStatus, payment.paymentStatus)&& Objects.equals(paymentDate, payment.paymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, bookingId, firstName, lastName, cardId, paymentStatus, paymentDate );
    }
}
