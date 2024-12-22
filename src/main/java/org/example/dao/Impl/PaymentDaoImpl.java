package org.example.dao.Impl;

import org.example.configuration.DataBaseConfig;
import org.example.dao.PaymentDao;
import org.example.entity.Payment;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PaymentDaoImpl extends AbstractDaoImpl<Payment> implements PaymentDao {
    public PaymentDaoImpl (DataBaseConfig dataBaseConfig) {super(dataBaseConfig);}


    @Override
    public Payment getByBookingId(long bookingId) {
        String query = "SELECT * FROM payment WHERE booking_id = ?";
        Payment payment = null;
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, bookingId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                long id = resultSet.getLong("payment_id");
                long cardId = resultSet.getLong("card_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String paymentStatus = resultSet.getString("payment_status");
                LocalDateTime paymentDate = resultSet.getTimestamp("payment_date").toLocalDateTime();

                payment = new Payment(id, bookingId, firstName, lastName, cardId, paymentStatus, paymentDate );
            }
            return payment;
        } catch (SQLException e) {
            throw new RuntimeException("Error while retrieving payment by booking id.");
        }
    }

    @Override
    public Payment getById(long id) {
        String query = "SELECT * FROM payment WHERE payment_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Payment(
                        resultSet.getLong("payment_id"),
                        resultSet.getLong("booking_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getLong("card_id"),
                        resultSet.getString("payment_status"),
                        resultSet.getTimestamp("payment_date").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Payment> getAll() {
        String query = "SELECT * FROM payment ";
        List<Payment> payments = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("payment_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                long bookingId = resultSet.getLong("booking_id");
                long cardId = resultSet.getLong("card_id");
                String paymentStatus = resultSet.getString("payment_status");
                LocalDateTime paymentDate = resultSet.getTimestamp("payment_date").toLocalDateTime();

                payments.add(new Payment(id, bookingId, firstName, lastName,  cardId, paymentStatus, paymentDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (payments);
    }

    @Override
    public Payment save(Payment payment) {
        String query = "INSERT INTO payment (booking_id, first_name, last_name, card_id, payment_status, payment_date) VALUES (?, ?, ?, ?, ?,?)";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setString(1, payment.getFirstName());
            statement.setString(2, payment.getLastName());
            statement.setLong(3, payment.getBookingId());
            statement.setLong(4, payment.getCardId());
            statement.setString(5, payment.getPaymentStatus());
            statement.setTimestamp(6, Timestamp.valueOf(payment.getPaymentDate()));


            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Payment saved successfully.");
                return payment;
            } else {
                System.out.println("Failed to save payment.");
                return payment;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while saving payment to the database.");
        }
    }

    @Override
    public Payment update(Payment payment, String params) {
        String query = "UPDATE payment SET booking_id = ? WHERE payment_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, Long.parseLong(params)); // seat_number             // model
            statement.setLong(2, payment.getPaymentId());

            statement.executeUpdate();

            payment.setBookingId(Long.parseLong(params));
            return payment;

        } catch (SQLException e) {
            throw new RuntimeException("EROOORRRRR");
        }
    }

    @Override
    public String delete(Payment payment) {
        String query = "DELETE FROM payment WHERE payment_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, payment.getPaymentId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return "Payment deleted successfully.";
            } else {
                return "No payment found with the given ID.";
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting payment from the database.");

        }
    }




}
