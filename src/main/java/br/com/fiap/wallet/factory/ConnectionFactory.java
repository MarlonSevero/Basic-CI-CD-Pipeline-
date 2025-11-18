package br.com.fiap.wallet.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String URL = "jdbc:postgresql://localhost:5432/mainproject";
    public static final String USER = "sys";
    public static final String PASSWORD = "senha123";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver"); // Driver JDBC do PostgreSQL
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver do PostgreSQL não encontrado!", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}