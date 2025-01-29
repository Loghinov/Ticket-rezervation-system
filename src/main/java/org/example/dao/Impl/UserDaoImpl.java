package org.example.dao.Impl;

import org.example.configuration.DataBaseConfig;
import org.example.dao.UserDao;
import org.example.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {
    public UserDaoImpl (DataBaseConfig dataBaseConfig) {super (dataBaseConfig);}

    @Override
    public User getByRoleId(long roleId) {
        String query = "SELECT * FROM users WHERE role_id = ?";
        User user = null;
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, roleId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                long userId = resultSet.getLong("user_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");

                user = new User(userId, firstName, lastName, age, roleId );
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException("Error while retrieving user by role id.");
        }
    }

    @Override
    public User getById(long id) {
        String query = "SELECT * FROM users WHERE user_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new User(
                        resultSet.getLong("user_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age"),
                        resultSet.getLong("role_id")

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        String query = "SELECT * FROM users ";
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("user_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                long roleId = resultSet.getLong("role_id");



                users.add(new User(id, firstName, lastName, age, roleId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (users);
    }

    @Override
    public User save(User user) {
        String query = "INSERT INTO users (first_name, last_name, age, role_id) VALUES (?, ?, ?, ?)";
        ResultSet resultSet = null;
        try (PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setLong(3, user.getAge());
            statement.setLong(4, user.getRoleId());



            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                long id = resultSet.getLong(1);
                user.setUserId(id);
                System.out.println("User saved successfully.");
                return user;
            } else {
                System.out.println("Failed to save user.");
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while saving passenger to the database.");
        }
    }

    @Override
    public User update(User user, String params) {
        String query = "UPDATE users SET role_id = ? WHERE user_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, Long.parseLong(params)); // seat_number             // model
            statement.setLong(2, user.getUserId());

            statement.executeUpdate();

            user.setRoleId(Long.parseLong(params));
            return user;

        } catch (SQLException e) {
            throw new RuntimeException("EROOORRRRR");
        }
    }

    @Override
    public String delete(long userId) {
        String query = "DELETE FROM users WHERE user_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, userId);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return "User deleted successfully.";
            } else {
                return "No User found with the given ID.";
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting user from the database.");

        }
    }
}
