package org.example.dao.Impl;

import org.example.configuration.DataBaseConfig;
import org.example.dao.PassengerDao;
import org.example.entity.Passenger;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PassengerDaoImpl extends AbstractDaoImpl<Passenger> implements PassengerDao {
    public PassengerDaoImpl(DataBaseConfig dataBaseConfig) {super(dataBaseConfig);}

    @Override
    public Passenger getByPassportNumber(long passportNumber) {
        String query = "SELECT * FROM passenger WHERE passport_number = ?";
        Passenger passenger = null;
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, passportNumber);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                long id = resultSet.getLong("passenger_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String citizenship = resultSet.getString("citizenship");
                String phoneNumber = resultSet.getString("phone_number");

                passenger = new Passenger(id, firstName, lastName, passportNumber, citizenship, phoneNumber);
            }
            return passenger;
        } catch (SQLException e) {
            throw new RuntimeException("Error while retrieving passenger by phone number.");
        }
    }

    @Override
    public Passenger getById(long id) {
        String query = "SELECT * FROM passenger WHERE passenger_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Passenger(
                        resultSet.getLong("passenger_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getLong("passport_number"),
                        resultSet.getString("citizenship"),
                        resultSet.getString("phone_number")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Passenger> getAll() {
        String query = "SELECT * FROM passenger ";
        List<Passenger> passengers = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("passenger_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                long passportNumber = resultSet.getLong("passport_number");
                String citizenship = resultSet.getString("citizenship");
                String phoneNumber = resultSet.getString("phone_number");

                passengers.add(new Passenger(id, firstName, lastName, passportNumber, citizenship, phoneNumber));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (passengers);
    }

    @Override
    public Passenger save(Passenger passenger) {
        String query = "INSERT INTO passenger (first_name, last_name, passport_number, citizenship, phone_number) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setString(1, passenger.getFirstName());
            statement.setString(2, passenger.getLastName());
            statement.setLong(3, passenger.getPassportNumber());
            statement.setString(4, passenger.getCitizenship());
            statement.setString(5, passenger.getPhoneNumber());


            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Passenger saved successfully.");
                return passenger;
            } else {
                System.out.println("Failed to save passenger.");
                return passenger;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while saving passenger to the database.");
        }
    }

    @Override
    public Passenger update(Passenger passenger, String params) {
        String query = "UPDATE passenger SET passport_number = ? WHERE passenger_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, Long.parseLong(params)); // seat_number             // model
            statement.setLong(2, passenger.getPassengerId());

            statement.executeUpdate();

            passenger.setPassportNumber(Long.parseLong(params));
            return passenger;

        } catch (SQLException e) {
            throw new RuntimeException("EROOORRRRR");
        }
    }

    @Override
    public String delete(Passenger passenger) {
        String query = "DELETE FROM passenger WHERE passenger_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, passenger.getPassengerId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return "Passenger deleted successfully.";
            } else {
                return "No passenger found with the given ID.";
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting passenger from the database.");

        }
    }
}
