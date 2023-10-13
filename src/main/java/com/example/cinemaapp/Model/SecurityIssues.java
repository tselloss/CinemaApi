package com.example.cinemaapp.Model;

import java.awt.datatransfer.DataFlavor;
import java.sql.*;

public class SecurityIssues {
    public void SqlInjection() throws Exception {
        try {
            String url = "jdbc:postgresql://your_postgresql_server:5432/your_database";
            String user = "your_username";
            String password = "your_password";

            // Establishing the connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Retrieving data with a SQL query
            DataFlavor request = null;
            String query = "SELECT account_balance FROM user_data WHERE user_name = '"
                    + request.getParameter("customerName") + "' or 1=1 limit 1";

            // Creating a statement
            Statement statement = connection.createStatement();

            // Executing the query
            ResultSet results = statement.executeQuery(query);

            // Process the results as needed

            // Closing resources
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            // Handle SQL exceptions
            throw new Exception("Security Issues");
        }
    }

    public void SqlInjectionCopy) throws Exception {
        try {
            String url = "jdbc:postgresql://your_postgresql_server:5432/your_database";
            String user = "your_username";
            String password = "your_password";

            // Establishing the connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Retrieving data with a SQL query
            DataFlavor request = null;
            String query = "SELECT account_balance FROM user_data WHERE user_name = '"
                    + request.getParameter("customerName") + "' or 1=1 limit 1";

            // Creating a statement
            Statement statement = connection.createStatement();

            // Executing the query
            ResultSet results = statement.executeQuery(query);

            // Process the results as needed

            // Closing resources
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            // Handle SQL exceptions
            throw new Exception("Security Issues");
        }
    }
}
