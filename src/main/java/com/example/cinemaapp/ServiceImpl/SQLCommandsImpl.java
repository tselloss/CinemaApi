package com.example.cinemaapp.ServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQLCommandsImpl {
    private String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    private String username = "postgres";
    private String password = "admin";

    public void findUserByNameAndPassword(String desiredUsername, String desiredPassword) {
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Prepare the SQL statement to call the function
            String sql = "SELECT * FROM find_user_by_name_and_pass(?, ?) OR 1=1--";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Set the parameters for the function
            preparedStatement.setString(1, "VagelisKarachristos");
            preparedStatement.setString(2, "a123456");

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String foundUsername = resultSet.getString("username");
                System.out.println("User ID: " + userId + ", Username: " + foundUsername);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
