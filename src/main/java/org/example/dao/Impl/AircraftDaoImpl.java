package org.example.dao.Impl;

import org.example.configuration.DataBaseConfig;
import org.example.dao.AircraftDao;
import org.example.entity.Aircraft;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AircraftDaoImpl extends AbstractDaoImpl<Aircraft> implements AircraftDao {
    public AircraftDaoImpl(DataBaseConfig dataBaseConfig) {
        super(dataBaseConfig);
    }

    @Override
    public Aircraft getByRegistrationNumber(long registrationNumber) {
        String query = "SELECT * FROM aircraft WHERE registration_number = ?";
        Aircraft aircraft = null;
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            // Set the registration_number in the prepared statement
            statement.setLong(1, registrationNumber);

            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                long id = resultSet.getLong("aircraft_id");
                long seatNumber = resultSet.getLong("seat_number");
                String model = resultSet.getString("model");

                // Create an Aircraft object from the result set
                aircraft = new Aircraft(id, seatNumber, registrationNumber, model);
            }
            return aircraft;
        } catch (SQLException e) {
            throw new RuntimeException("Error while retrieving aircraft by registration number.");
        }
    }

    @Override
    public Aircraft getById(long id) {
        String query = "SELECT * FROM aircraft WHERE aircraft_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Aircraft(
                        resultSet.getLong("aircraft_id"),
                        resultSet.getLong("seat_number"),
                        resultSet.getLong("registration_number"),
                        resultSet.getString("model")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Aircraft> getAll() {
        String query = "SELECT * FROM aircraft ";
        List<Aircraft> aircrafts = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("aircraft_id");
                long seatNumber = resultSet.getLong("seat_number");
                long registrationNumber = resultSet.getLong("registration_number");
                String model = resultSet.getString("model");
                aircrafts.add(new Aircraft(id, seatNumber, registrationNumber, model));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (aircrafts);

    }

    @Override
    public Aircraft save(Aircraft aircraft) {
        String query = "INSERT INTO aircraft (seat_number, registration_number, model) VALUES (?, ?, ?)";
        ResultSet resultSet = null;
        try (PreparedStatement statement = getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Set the parameters for the PreparedStatement
            statement.setLong(1, aircraft.getSeatNumber());
            statement.setLong(2, aircraft.getRegistrationNumber());
            statement.setString(3, aircraft.getModel());

            // Execute the update to insert the data
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                long id = resultSet.getLong("aircraft_id");
                aircraft.setAircraftId(id);
                return aircraft;
            } else {
                System.out.println("Failed to save aircraft.");
                return aircraft;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while saving aircraft to the database.");
        }

    }

    @Override
    public Aircraft update(Aircraft aircraft, String params) {
        String query = "UPDATE aircraft SET registration_number = ? WHERE aircraft_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, Long.parseLong(params)); // seat_number             // model
            statement.setLong(2, aircraft.getAircraftId());

            statement.executeUpdate();

            aircraft.setRegistrationNumber(Long.parseLong(params));
            return aircraft;

        } catch (SQLException e) {
            throw new RuntimeException("EROOORRRRR");
        }

    }

    @Override
    public String delete(Aircraft aircraft) {
        String query = "DELETE FROM aircraft WHERE aircraft_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            // Set the aircraft_id parameter in the PreparedStatement
            statement.setLong(1, aircraft.getAircraftId());

            // Execute the delete statement
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return "Aircraft deleted successfully.";
            } else {
                return "No aircraft found with the given ID.";
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting aircraft from the database.");

        }
    }
}


