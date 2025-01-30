package java_project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private static final String URL = "jdbc:sqlite:java_project.db"; // SQLite Database
    private static final String DRIVER = "org.sqlite.JDBC"; // SQLite Driver

    // 📌 Подключение к базе данных
    private Connection connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQLite Driver not found!", e);
        }
        return DriverManager.getConnection(URL);
    }

    // 📌 Добавление бронирования (CREATE)
    public void addBooking(int filmId, int viewerId, String status) {
        String sql = "INSERT INTO bookings (film_id, viewer_id, status) VALUES (?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, filmId);
            pstmt.setInt(2, viewerId);
            pstmt.setString(3, status);
            pstmt.executeUpdate();

            System.out.println("✅ Booking added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 📌 Получение всех бронирований (READ)
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Booking booking = new Booking(
                    rs.getInt("id"),
                    rs.getInt("film_id"),
                    rs.getInt("viewer_id"),
                    rs.getString("status")
                );
                bookings.add(booking);
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
