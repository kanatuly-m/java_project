package java_project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewerDAO {
    // 📌 Подключение к SQLite
    private Connection connect() throws SQLException {
        return DatabaseManager.connect();
    }

    // 📌 Добавление зрителя (CREATE)
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

    // 📌 Получение всех зрителей (READ)
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

    // 📌 Получение зрителя по ID (NEW) 🚀
    public Viewer getViewerById(int id) {
        String sql = "SELECT * FROM viewers WHERE id = ?";
        Viewer viewer = null;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                viewer = new Viewer(rs.getInt("id"), rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return viewer;
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
