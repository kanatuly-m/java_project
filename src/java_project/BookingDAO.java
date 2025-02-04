package java_project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private static final String URL = "jdbc:sqlite:java_project.db"; // SQLite Database

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // 📌 Добавление бронирования (CREATE)
    public void addBooking(Film film, Viewer viewer, String status) {
        String sql = "INSERT INTO bookings (film_id, viewer_id, status) VALUES (?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, film.getId());
            pstmt.setInt(2, viewer.getId());
            pstmt.setString(3, status);
            pstmt.executeUpdate();

            System.out.println("✅ Booking added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 📌 Получение всех бронирований (READ)
    public List<Booking> getAllBookings(FilmDAO filmDAO, ViewerDAO viewerDAO) {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Film film = filmDAO.getFilmById(rs.getInt("film_id")); // ✅ Исправлено
                Viewer viewer = viewerDAO.getAllViewers().stream()
                    .filter(v -> v.getId() == rs.getInt("viewer_id")) // ✅ Исправлено
                    .findFirst()
                    .orElse(null);

                bookings.add(new Booking(rs.getInt("id"), film, viewer, rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    // 📌 Обновление бронирования (UPDATE)
    public void updateBooking(int id, String status) {
        String sql = "UPDATE bookings SET status = ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, status);
            pstmt.setInt(2, id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("✅ Booking updated successfully!");
            } else {
                System.out.println("⚠️ Booking not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 📌 Удаление бронирования (DELETE)
    public void deleteBooking(int id) {
        String sql = "DELETE FROM bookings WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("✅ Booking deleted successfully!");
            } else {
                System.out.println("⚠️ Booking not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
