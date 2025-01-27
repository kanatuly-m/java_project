import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewerDAO {
    private static final String URL = "jdbc:sqltools:cinema_reservation";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // 📌 Добавление нового зрителя
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

    // 📌 Получение всех зрителей
    public List<String> getAllViewers() {
        List<String> viewers = new ArrayList<>();
        String sql = "SELECT * FROM viewers";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                viewers.add(rs.getInt("id") + ". " + rs.getString("name") + " - " + rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return viewers;
    }
}
