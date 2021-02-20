package com.menfin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    private Connection connection;
    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/storageBooks";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres";

    public Config() {
        initDB();
    }

    private void initDB() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Connection is true! ");
            }
            if (connection.isClosed()) {
                System.out.println("Connection is false! ");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
}
