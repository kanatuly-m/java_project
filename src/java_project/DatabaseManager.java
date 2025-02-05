package java_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:java_project.db"; // SQLite database

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
