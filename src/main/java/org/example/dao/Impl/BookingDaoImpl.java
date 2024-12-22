package org.example.dao.Impl;

import org.example.configuration.DataBaseConfig;
import org.example.dao.BookingDao;
import org.example.entity.Booking;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingDaoImpl extends AbstractDaoImpl<Booking> implements BookingDao {
    public BookingDaoImpl(DataBaseConfig dataBaseConfig) {
        super(dataBaseConfig);
    }

    @Override
    public Booking getByUserId(long userId) {
        String query = "Select * from booking where user_id = ?";
        Booking booking = null;
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                long id = resultSet.getLong("booking_id");
                long ticketTurId = resultSet.getLong("ticket_tur_id");
                long ticketReturId = resultSet.getLong("ticket_retur_id");

                booking = new Booking(id, userId, ticketTurId, ticketReturId);
            }
            return booking;
        } catch (SQLException e) {
            throw new RuntimeException("Error while retrieving booking by user id");
        }
    }

    @Override
    public Booking getById(long id) {
        String query = "select * from booking where booking_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Booking(
                        resultSet.getLong("booking_id"),
                        resultSet.getLong("user_id"),
                        resultSet.getLong("ticket_tur_id"),
                        resultSet.getLong("ticket_retur_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Booking> getAll() {
        String query = "select * from booking";
        List<Booking> booking = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("booking_id");
                long userId = resultSet.getLong("user_id");
                long ticketTurId = resultSet.getLong("ticket_tur_id");
                long ticketReturId = resultSet.getLong("ticket_retur_id");
                booking.add(new Booking(id, userId, ticketTurId, ticketReturId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (booking);
    }

    @Override
    public Booking save(Booking booking) {
        String query = "Insert into booking (user_id, ticket_tur_id, ticket_retur_id) values(?,?,?)";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, booking.getUserId());
            statement.setLong(2, booking.getTicketTurId());
            statement.setLong(3, booking.getTicketReturId());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Booking saved successfully.");
                return booking;
            } else {
                System.out.println("Failed to save booking");
                return booking;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error");
        }
    }

    @Override
    public Booking update(Booking booking, String params) {
        String query = "Update booking set user_id = where booking_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, Long.parseLong(params));
            statement.setLong(2, booking.getBookingId());
            statement.execute();
            booking.setUserId(Long.parseLong(params));
            return booking;
        } catch (SQLException e) {
            throw new RuntimeException("Erorr");
        }
    }

    @Override
    public String delete(Booking booking) {
        String query = "Delete from booking where booking_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, booking.getBookingId());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return "Booking deleted successfully.";
            } else {
                return "No booking found with the given Id.";
            }
        } catch (SQLException e) {
            throw new RuntimeException("Errorr");
        }
    }
}
