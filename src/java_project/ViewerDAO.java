package java_project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewerDAO {
    private static final String URL = "jdbc:sqlite:java_project.db"; // SQLite Database

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // 📌 Добавление зрителя
    public void addViewer(String name) {
        String sql = "INSERT INTO viewers (name) VALUES (?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("✅ Viewer added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 📌 Получение всех зрителей
    public List<Viewer> getAllViewers() {
        List<Viewer> viewers = new ArrayList<>();
        String sql = "SELECT * FROM viewers";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                viewers.add(new Viewer(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return viewers;
    }
}
