package java_project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewerDAO {
    private static final String URL = "jdbc:sqlite:java_project.db"; // SQLite Database
    private static final String DRIVER = "org.sqlite.JDBC"; // SQLite Driver

    // 📌 Подключение к базе данных
    private Connection connect() throws SQLException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQLite Driver not found!", e);
        }
        return DriverManager.getConnection(URL);
    }

    // 📌 Добавление зрителя (CREATE)
    public void addViewer(String name, String email) {
        String sql = "INSERT INTO viewers (name, email) VALUES (?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.executeUpdate();

            System.out.println("✅ Viewer added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 📌 Получение всех зрителей (READ)
    public List<Viewer> getAllViewers() {
        List<Viewer> viewers = new ArrayList<>();
        String sql = "SELECT * FROM viewers";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Viewer viewer = new Viewer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email")
                );
                viewers.add(viewer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return viewers;
    }

    // 📌 Обновление информации о зрителе (UPDATE)
    public void updateViewer(int id, String name, String email) {
        String sql = "UPDATE viewers SET name = ?, email = ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("✅ Viewer updated successfully!");
            } else {
                System.out.println("⚠️ Viewer not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 📌 Удаление зрителя (DELETE)
    public void deleteViewer(int id) {
        String sql = "DELETE FROM viewers WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("✅ Viewer deleted successfully!");
            } else {
                System.out.println("⚠️ Viewer not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
