package com.haemimont.cars.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginStatements {


    public static int insertUserName(Connection connection) {
        int result = 0;
        String sqlLogin = "INSERT INTO csv_cars_db.login ( username,password ) VALUES( ?,? )";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlLogin,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1,"Atanas");
            statement.setInt(2,123456);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

            while (resultSet.next()) {
                result = resultSet.getInt(1);
            }

            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return result;
    }
}
