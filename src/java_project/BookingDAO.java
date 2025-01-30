package java_project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private static final String URL = "jdbc:sqlite:cinema_reservation.db";  // ✅ SQLite Database
    private static final String DRIVER = "org.sqlite.JDBC";  // ✅ SQLite Driver

    // 📌 Подключение к базе данных
    private Connection connect() throws SQLException {
        try {
            Class.forName(DRIVER);  // ✅ Регистрация драйвера SQLite
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQLite Driver not found!", e);
        }
        return DriverManager.getConnection(URL);
    }

    // 📌 Добавление бронирования
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

    // 📌 Получение всех бронирований
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Booking booking = new Booking(
                    rs.getInt("id"),         // ✅ Убрали columnLabel:
                    rs.getInt("film_id"),    // ✅ Убрали columnLabel:
                    rs.getInt("viewer_id"),  // ✅ Убрали columnLabel:
                    rs.getString("status")   // ✅ Убрали columnLabel:
                );
                bookings.add(booking);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }

    // 📌 Удаление бронирования
    public void deleteBooking(int bookingId) {
        String sql = "DELETE FROM bookings WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, bookingId);
            pstmt.executeUpdate();

            System.out.println("✅ Booking deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
