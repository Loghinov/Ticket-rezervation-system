package org.example.dao.Impl;

import org.example.configuration.DataBaseConfig;
import org.example.dao.SeatDao;
import org.example.entity.Seat;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class SeatDaoImpl extends AbstractDaoImpl<Seat> implements SeatDao {
    public SeatDaoImpl(DataBaseConfig dataBaseConfig) {super (dataBaseConfig);}

    @Override
    public Seat getBySeatCode(String seatCode) {
        String query = "SELECT * FROM seats WHERE seat_code = ?";
        Seat seat = null;
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setString(1, seatCode);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                long id = resultSet.getLong("seat_id");
                boolean seatAvailable = resultSet.getBoolean("seat_available");
                long flyId = resultSet.getLong("fly_id");

                seat = new Seat(id, seatCode, seatAvailable, flyId);
            }
            return seat;
        } catch (SQLException e) {
            throw new RuntimeException("Error while retrieving seat by seat code.");
        }
    }

    @Override
    public Seat getById(long id) {
        String query = "SELECT * FROM seats WHERE seat_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Seat(
                        resultSet.getLong("seat_id"),
                        resultSet.getString("seat_code"),
                        resultSet.getBoolean("seat_available"),
                        resultSet.getLong("fly_id")

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Seat> getAll() {
        String query = "SELECT * FROM seats ";
        List<Seat> seats = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("seat_id");
                String seatCode = resultSet.getString("seat_code");
                boolean seatAvailable = resultSet.getBoolean("seat_available");
                long flyId = resultSet.getLong("fly_id");

                seats.add(new Seat(id, seatCode, seatAvailable, flyId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (seats);
    }

    @Override
    public Seat save(Seat seat) {
        String query = "INSERT INTO seats (seat_code, seat_available, fly_id) VALUES (?, ?, ?)";

        try (PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {


            statement.setString(2, seat.getSeatCode());
            statement.setBoolean(3, seat.getSeatAvailable());
            statement.setLong(4, seat.getAircraftId());



            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Seat saved successfully.");
                return seat;
            } else {
                System.out.println("Failed to save seat.");
                return seat;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while saving seat to the database.");
        }
    }

    @Override
    public Seat update(Seat seat, String params) {
        String query = "UPDATE seat SET seat_code = ? WHERE seat_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, Long.parseLong(params)); // seat_number             // model
            statement.setLong(2, seat.getSeatId());

            statement.executeUpdate();

            seat.setSeatCode(params);
            return seat;

        } catch (SQLException e) {
            throw new RuntimeException("EROOORRRRR");
        }
    }

    @Override
    public String delete(Seat seat) {
        String query = "DELETE FROM seat WHERE seat_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, seat.getSeatId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return "Seat deleted successfully.";
            } else {
                return "No seat found with the given ID.";
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting seat from the database.");

        }
    }
}
