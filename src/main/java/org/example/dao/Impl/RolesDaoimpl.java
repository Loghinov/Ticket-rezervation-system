package org.example.dao.Impl;

import org.example.configuration.DataBaseConfig;
import org.example.dao.RolesDao;
import org.example.entity.Role;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class RolesDaoimpl extends AbstractDaoImpl<Role> implements RolesDao {
    public RolesDaoimpl(DataBaseConfig dataBaseConfig) {super(dataBaseConfig);}

    @Override
    public Role getByRoleName(String roleName) {
        String query = "SELECT * FROM roles WHERE role_name = ?";
        Role role = null;
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setString(1, roleName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                long id = resultSet.getLong("role_id");
                role = new Role(id, roleName);
            }
            return role;
        } catch (SQLException e) {
            throw new RuntimeException("Error while retrieving roles by role name.");
        }
    }
    @Override
    public Role getById(long id) {
        String query = "SELECT * FROM roles WHERE role_id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Role(
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
    public List<Role> getAll() {
        String query = "SELECT * FROM roles ";
        List<Role> roles = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("passenger_id");
                String roleName = resultSet.getString("role_name");

                roles.add(new Role(id, roleName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (roles);
    }

    @Override
    public Role save(Role role) {
        String query = "INSERT INTO roles (role_name) VALUES (?)";

        try (PreparedStatement statement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {


            statement.setString(1, role.getRoleName());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Roles saved successfully.");
                return role;
            } else {
                System.out.println("Failed to save roles.");
                return role;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while saving roles to the database.");
        }
    }

    @Override
    public Role update(Role role, String params) {
        String query = "UPDATE roles SET role_name = ? WHERE role_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, Long.parseLong(params)); // seat_number             // model
            statement.setLong(2, role.getRoleId());

            statement.executeUpdate();

            role.setRoleName(String.valueOf(Long.parseLong(params)));
            return role;

        } catch (SQLException e) {
            throw new RuntimeException("EROOORRRRR");
        }
    }

    @Override
    public String delete(Role role) {
        String query = "DELETE FROM roles WHERE roles_id = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {

            statement.setLong(1, role.getRoleId());

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
