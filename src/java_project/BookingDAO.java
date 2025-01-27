package java_project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/cinema_reservation";
    private static final String USER = "postgres";
    private static final String PASSWORD = "your_password";  // ⚠️ Укажи свой пароль!

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
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

    // 📌 Добавление нескольких бронирований
    public void addMultipleBookings(int filmId, List<Integer> viewerIds) {
        String sql = "INSERT INTO bookings (film_id, viewer_id, status) VALUES (?, ?, 'reserved')";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (int viewerId : viewerIds) {
                pstmt.setInt(1, filmId);
                pstmt.setInt(2, viewerId);
                pstmt.executeUpdate();
            }

            System.out.println("✅ Multiple bookings added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 📌 Получение всех бронирований
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Booking booking = new Booking(
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

    // 📌 Обновление статуса бронирования
    public void updateBookingStatus(int bookingId, String newStatus) {
        String sql = "UPDATE bookings SET status = ? WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newStatus);
            pstmt.setInt(2, bookingId);
            pstmt.executeUpdate();

            System.out.println("✅ Booking status updated!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
