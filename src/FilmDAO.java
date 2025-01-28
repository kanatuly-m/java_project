import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FilmDAO {
    public static void addFilm(String title, String genre, int duration) {
        String sql = "INSERT INTO films (title, genre, duration) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, genre);
            pstmt.setInt(3, duration);
            pstmt.executeUpdate();
            System.out.println("Film added successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        addFilm("Avatar", "Sci-Fi", 162);
    }
}
