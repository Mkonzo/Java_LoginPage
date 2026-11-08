
package Swing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentication {

    public static boolean login(String userID, String password)
            throws SQLException {

        String sql =
                "SELECT * FROM users WHERE userID = ? AND password = ?";

        try (Connection connection =
                     DatabaseConnection.getConnection();

             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, userID);
            statement.setString(2, password);

            try (ResultSet result = statement.executeQuery()) {

                return result.next();
            }
        }
    }
}




