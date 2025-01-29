package org.example.dao.Impl;

import org.example.configuration.DataBaseConfig;
import org.example.dao.AirlineDao;
import org.example.entity.Airline;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AirlineDaoImpl extends AbstractDaoImpl<Airline> implements AirlineDao {
    public AirlineDaoImpl(DataBaseConfig dataBaseConfig) {
        super(dataBaseConfig);
    }

    @Override
    public Airline getByCode(long code) {
        String query = "Select * from airlines where airline_code = ?";
        Airline airline = null;
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setLong(1, code);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong("airline_id");
                String name = resultSet.getString("airline_name");

                airline = new Airline(id, code, name);
            }
            return airline;
        } catch (SQLException e) {
            throw new RuntimeException("error at airline get by code");
        }
    }

    @Override
    public Airline getById(long id) {
        String query = "SELECT * FROM airlines WHERE airline_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Airline(
                        resultSet.getLong("airline_id"),
                        resultSet.getLong("airline_code"),
                        resultSet.getString("airline_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Airline> getAll() {
        String query = "SELECT * FROM airlines ";
        List<Airline> airlines = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("airline_id");
                long code = resultSet.getLong("airline_code");
                String name = resultSet.getString("airline_name");
                airlines.add(new Airline(id, code, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (airlines);
    }

    @Override
    public Airline save(Airline airline) {
        String query = "INSERT INTO airlines (airline_code, airline_name) VALUES (?, ?)";

        try (PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {


            // Set the parameters for the PreparedStatement
            statement.setLong(1, airline.getAirlineCode());
            statement.setString(2, airline.getAirlineName());

            // Execute the update to insert the data
            int rowsAffected = statement.executeUpdate();
            // KEY HOLDER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
            if (rowsAffected > 0) {
                System.out.println("Airline saved successfully.");
                return airline;
            } else {
                System.out.println("Failed to save airline.");
                return airline;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while saving airline to the database.");
        }
    }

    @Override
    public Airline update(Airline airline, String params) {
        String query = "UPDATE airlines SET airline_code = ? WHERE airline_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, Long.parseLong(params));
            statement.setLong(2, airline.getAirlineId());

            statement.executeUpdate();

            airline.setAirlineCode(Long.parseLong(params));
            return airline;

        } catch (SQLException e) {
            throw new RuntimeException("EROOORRRRR");
        }
    }

    @Override
    public String delete(Airline airline) {
        String query = "DELETE FROM airlines WHERE airline_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            // Set the aircraft_id parameter in the PreparedStatement
            statement.setLong(1, airline.getAirlineId());

            // Execute the delete statement
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return "Airline deleted successfully.";
            } else {
                return "No airline found with the given ID.";
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting airline from the database.");

        }
    }
}
