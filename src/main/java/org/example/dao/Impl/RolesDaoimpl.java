package org.example.dao.Impl;

import org.example.configuration.DataBaseConfig;
import org.example.dao.RolesDao;
import org.example.entity.Roles;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class RolesDaoimpl extends AbstractDaoImpl<Roles> implements RolesDao {
    public RolesDaoimpl(DataBaseConfig dataBaseConfig) {super(dataBaseConfig);}

    @Override
    public Roles getByRoleName(String roleName) {
        String query = "SELECT * FROM roles WHERE role_name = ?";
        Roles roles = null;
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setString(1, roleName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                long id = resultSet.getLong("role_id");
                roles = new Roles(id, roleName);
            }
            return roles;
        } catch (SQLException e) {
            throw new RuntimeException("Error while retrieving roles by role name.");
        }
    }
    @Override
    public Roles getById(long id) {
        String query = "SELECT * FROM roles WHERE role_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Roles(
                        resultSet.getLong("role_id"),
                        resultSet.getString("role_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Roles> getAll() {
        String query = "SELECT * FROM roles ";
        List<Roles> roles = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("passenger_id");
                String roleName = resultSet.getString("role_name");

                roles.add(new Roles(id, roleName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (roles);
    }

    @Override
    public Roles save(Roles roles) {
        String query = "INSERT INTO roles (role_name) VALUES (?)";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setString(1, roles.getRoleName());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Roles saved successfully.");
                return roles;
            } else {
                System.out.println("Failed to save roles.");
                return roles;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while saving roles to the database.");
        }
    }

    @Override
    public Roles update(Roles roles, String params) {
        String query = "UPDATE roles SET role_name = ? WHERE role_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, Long.parseLong(params)); // seat_number             // model
            statement.setLong(2, roles.getRolesId());

            statement.executeUpdate();

            roles.setRoleName(String.valueOf(Long.parseLong(params)));
            return roles;

        } catch (SQLException e) {
            throw new RuntimeException("EROOORRRRR");
        }
    }

    @Override
    public String delete(Roles roles) {
        String query = "DELETE FROM roles WHERE roles_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, roles.getRolesId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                return "Roles deleted successfully.";
            } else {
                return "No roles found with the given ID.";
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting roles from the database.");

        }
    }
}
