package org.example.dao.Impl;

import org.example.configuration.DataBaseConfig;
import org.example.dao.TicketDao;
import org.example.entity.Ticket;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class TicketDaoImpl extends AbstractDaoImpl<Ticket> implements TicketDao {
    public TicketDaoImpl (DataBaseConfig dataBaseConfig) {super (dataBaseConfig);}

    @Override
    public Ticket getByPassengerId(long passengerId) {
        String query = "SELECT * FROM tickets WHERE passenger_id = ?";
        Ticket ticket = null;
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, passengerId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                long id = resultSet.getLong("ticket_id");
                long flyId = resultSet.getLong("fly_id");
                long seatId = resultSet.getLong("seat_id");


                ticket = new Ticket(id, flyId, passengerId, seatId);
            }
            return ticket;
        } catch (SQLException e) {
            throw new RuntimeException("Error while retrieving ticket by passenger id.");
        }
    }

    @Override
    public Ticket getById(long id) {
        String query = "SELECT * FROM tickets WHERE ticket_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                long flyId = resultSet.getLong("fly_id");
                long passengerId = resultSet.getLong("passenger_id");
                long seatId = resultSet.getLong("seat_id");

                return new Ticket(id, flyId, passengerId, seatId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ticket> getAll() {
        String query = "SELECT * FROM tickets ";
        List<Ticket> tickets = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("ticket_id");
                long flyId = resultSet.getLong("fly_id");
                long passengerId = resultSet.getLong("passenger_id");
                long seatId = resultSet.getLong("seat_id");


                tickets.add(new Ticket(id, flyId, passengerId, seatId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (tickets);
    }

    @Override
    public Ticket save(Ticket ticket) {
        String query = "INSERT INTO tickets (fly_id, passenger_id, seat_id) VALUES ( ?, ?, ?)";

        try (PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setLong(1, ticket.getFlyId());
            statement.setLong(2, ticket.getPassengerId());
            statement.setLong(3, ticket.getSeatId());



            int rowsAffected = statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();


            if (resultSet.next()) {
                long id = resultSet.getLong(1);
                ticket.setTicketId(id);
                System.out.println("Ticket saved successfully.");
                return ticket;
            } else {
                System.out.println("Failed to save ticket.");
                return ticket;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while saving ticket to the database.");
        }
    }

    @Override
    public Ticket update(Ticket ticket, String params) {
        String query = "UPDATE tickets SET passenger_id = ? WHERE ticket_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, Long.parseLong(params)); // seat_number             // model
            statement.setLong(2, ticket.getTicketId());

            statement.executeUpdate();

            ticket.setPassengerId(Long.parseLong(params));
            return ticket;

        } catch (SQLException e) {
            throw new RuntimeException("EROOORRRRR");
        }
    }

    @Override
    public String delete(Ticket ticket) {
        String query = "DELETE FROM tickets WHERE ticket_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, ticket.getTicketId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return "Ticket deleted successfully.";
            } else {
                return "No ticket found with the given ID.";
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting ticket from the database.");

        }
    }
}
