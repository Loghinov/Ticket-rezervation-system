package org.example.dao.Impl;

import org.example.configuration.DataBaseConfig;
import org.example.dao.Dao;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Repository
public abstract class AbstractDaoImpl<T> implements Dao<T> {
    protected Connection connection;

    protected AbstractDaoImpl(DataBaseConfig config) {
        try {
            // Establish connection using parameters from config
            if (connection == null) {
                connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to establish connection with the database.");
        }
    }

    // Metodă pentru obținerea conexiunii
    protected Connection getConnection() {
         return connection;
    }

}
