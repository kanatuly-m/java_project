package java_project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {
    public void addFilm(String title, String genre, int duration) {
        String sql = "INSERT INTO films (title, genre, duration) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, genre);
            pstmt.setInt(3, duration);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Film getFilmById(int id) {
        String sql = "SELECT * FROM films WHERE id = ?";
        Film film = null;

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                film = new Film(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("genre"),
                    rs.getInt("duration")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    public List<Film> getAllFilms() {
        List<Film> films = new ArrayList<>();
        String sql = "SELECT * FROM films";

        try (Connection conn = DatabaseManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                films.add(new Film(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("genre"),
                    rs.getInt("duration")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }
}
