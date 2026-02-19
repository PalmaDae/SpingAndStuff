package data;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DataClass {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/spring",
                    "postgres",
                    "010909"
            );
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
