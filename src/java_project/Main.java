package java_project;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookingDAO bookingDAO = new BookingDAO();

        // 📌 Добавляем бронирование
        bookingDAO.addBooking(1, 2, "reserved");

        // 📌 Получаем список всех бронирований
        List<Booking> bookings = bookingDAO.getAllBookings();
        for (Booking booking : bookings) {
            System.out.println("🎟️ Booking: Film ID = " + booking.getFilmId() + 
                               ", Viewer ID = " + booking.getViewerId() + 
                               ", Status = " + booking.getStatus());
        }
    }
}
