package org.example;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection connection;
    private Statement statement;

    public Database() {
        try {
            loadDriver();
            initConnection();
            initTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void loadDriver() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }

    private void initConnection() throws SQLException {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "postgrespass";
        connection = DriverManager.getConnection(jdbcUrl, username, password);
        statement = connection.createStatement();
        System.out.println("Connection effectuée");
    }

    private void initTable() throws SQLException {
        String createTable = "CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, name VARCHAR(50), email VARCHAR(50))";
        statement.execute(createTable);
    }

    public void createUser(User user) throws SQLException {
        System.out.println("Creating user: " + user.name());
        String insertSQL
                = String.format("INSERT INTO users (name, email) VALUES ('%s', '%s')", user.name(), user.email());
        statement.executeUpdate(insertSQL);
    }

    public User[] getAllUsers() throws SQLException {
        String selectSQL = "SELECT * FROM users ";
        final ResultSet resultSet = statement.executeQuery(selectSQL);
        User[] users = new User[0];
        ArrayList<User> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new User(resultSet.getString("name"), resultSet.getString("email")));
        }
        return list.toArray(users);
    }

    public void authenticateUser(String username, String password)
            throws SQLException {
        String selectUser
                = String.format(
                "SELECT * FROM users WHERE name='%s' AND password='%s'"
                , username
                , password);
        ResultSet resultSet = statement.executeQuery(selectUser);
        if (!resultSet.next()) {
            throw new SQLException("Invalid username or password");
        }
    }

    protected void finalize() {
        try {
            connection.close();
            System.out.println("Connection closed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
