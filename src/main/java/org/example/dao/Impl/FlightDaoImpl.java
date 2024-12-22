package org.example.dao.Impl;

import org.example.configuration.DataBaseConfig;
import org.example.dao.FlightDao;
import org.example.entity.Flight;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Repository
public class FlightDaoImpl extends AbstractDaoImpl<Flight> implements FlightDao {
    public FlightDaoImpl(DataBaseConfig dataBaseConfig) {
        super(dataBaseConfig);
    }


    @Override
    public Flight getByDepartureAirportId(long departureAirportId) {
        String query = "SELECT * FROM flight WHERE departure_airport_id = ?";
        Flight flight = null;
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            // Set the registration_number in the prepared statement
            statement.setLong(1, departureAirportId);

            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                long id = resultSet.getLong("flight_id");
                long arrivalAirportId = resultSet.getLong("arrival_airport_id");
                long airlineId = resultSet.getLong("airline_id");
                LocalDateTime departureTime = resultSet.getTimestamp("time_departure").toLocalDateTime();
                LocalDateTime arrivalTime = resultSet.getTimestamp("time_arrival").toLocalDateTime();
                double price = resultSet.getDouble("price");

                // Create an Aircraft object from the result set
                flight = new Flight(id,departureAirportId, arrivalAirportId, airlineId, departureTime, arrivalTime, price);
            }
            return flight;
        } catch (SQLException e) {
            throw new RuntimeException("Error while retrieving flight by departure airport id.");
        }
    }

    @Override
    public Flight getById(long id) {
        String query = "select * from flight where flight_id = ?";
        try (PreparedStatement statement=getConnection().prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Flight (
                        resultSet.getLong("flight_id"),
                        resultSet.getLong("departure_airport_id"),
                        resultSet.getLong("arrival_airport_id"),
                        resultSet.getLong("airline_id"),
                        resultSet.getTimestamp("departure_time").toLocalDateTime(),
                        resultSet.getTimestamp("arrival_time").toLocalDateTime(),
                        resultSet.getDouble("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Flight> getAll() {
        String query = "SELECT * FROM flight ";
        List<Flight> flight = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("flight_id");
                long departureAirportId = resultSet.getLong("departure_airport_id");
                long arrivalAirportId = resultSet.getLong("arrival_airport_id");
                long airlineId = resultSet.getLong("airline_id");
                LocalDateTime departureTime = resultSet.getTimestamp("departure_time").toLocalDateTime();
                LocalDateTime arrivalTime = resultSet.getTimestamp("arrival_time").toLocalDateTime();
                double price = resultSet.getDouble("price");
                flight.add(new Flight(id, departureAirportId, arrivalAirportId, airlineId, departureTime, arrivalTime, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (flight);
    }

    @Override
    public Flight save(Flight flight) {
        String query = "insert into flight (departure_airport_id, arrival_airport_id, airline_id, departure_time, arrival_time, price) values(?,?,?,?,?,?)";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, flight.getDepartureAirportId());
            statement.setLong(2, flight.getArrivalAirportId());
            statement.setLong(3, flight.getAirlineId());
            statement.setTimestamp(4, Timestamp.valueOf(flight.getDepartureTime()));
            statement.setTimestamp(5, Timestamp.valueOf(flight.getArrivalTime()));
            statement.setDouble(6, flight.getPrice());


            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Flight saved successfully.");
                return flight;
            } else {
                System.out.println("Failed to save flight.");
                return flight;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while saving flight to the database.");
        }
    }

    @Override
    public Flight update(Flight flight, String params) {
        String query = "UPDATE flight SET departure_airport_id = ? WHERE flight_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, Long.parseLong(params)); // seat_number             // model
            statement.setLong(2, flight.getFlightId());

            statement.executeUpdate();

            flight.setDepartureAirportId(Long.parseLong(params));
            return flight;

        } catch (SQLException e) {
            throw new RuntimeException("EROOORRRRR");
        }
    }

    @Override
    public String delete(Flight flight) {
        String query = "DELETE FROM flight WHERE flight_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {


            statement.setLong(1, flight.getFlightId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return "Flight deleted successfully.";
            } else {
                return "No flight found with the given ID.";
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting flight from the database.");

        }
    }
}
