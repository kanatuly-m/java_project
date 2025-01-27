import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {
    private static final String URL = "jdbc:sqltools:cinema_reservation";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // 📌 Добавление нового фильма
    public void addFilm(String title, String genre, int duration) {
        String sql = "INSERT INTO films (title, genre, duration) VALUES (?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, genre);
            pstmt.setInt(3, duration);
            pstmt.executeUpdate();

            System.out.println("✅ Film added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 📌 Получение всех фильмов
    public List<String> getAllFilms() {
        List<String> films = new ArrayList<>();
        String sql = "SELECT * FROM films";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                films.add(rs.getInt("id") + ". " + rs.getString("title") + " - " + rs.getString("genre") + " (" + rs.getInt("duration") + " min)");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }
}
