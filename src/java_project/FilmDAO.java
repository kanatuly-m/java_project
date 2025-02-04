package java_project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {
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

    // 📌 Добавление фильма (CREATE)
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

    // 📌 Получение всех фильмов (READ)
    public List<Film> getAllFilms() {
        List<Film> films = new ArrayList<>();
        String sql = "SELECT * FROM films";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Film film = new Film(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("genre"),
                    rs.getInt("duration")
                );
                films.add(film);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }

    // 📌 Обновление информации о фильме (UPDATE)
    public void updateFilm(int id, String title, String genre, int duration) {
        String sql = "UPDATE films SET title = ?, genre = ?, duration = ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, genre);
            pstmt.setInt(3, duration);
            pstmt.setInt(4, id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("✅ Film updated successfully!");
            } else {
                System.out.println("⚠️ Film not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 📌 Удаление фильма (DELETE)
    public void deleteFilm(int id) {
        String sql = "DELETE FROM films WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("✅ Film deleted successfully!");
            } else {
                System.out.println("⚠️ Film not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
public Film getFilmById(int id) {
    String sql = "SELECT * FROM films WHERE id = ?";
    Film film = null;

    try (Connection conn = connect();
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
