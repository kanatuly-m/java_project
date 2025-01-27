package java_project;
import java.util.Arrays;
import java.util.List;
import java_project.BookingDAO;  // ✅ Импортируем BookingDAO

public class Main {
    public static void main(String[] args) {
        BookingDAO bookingDAO = new BookingDAO();

        // 📌 Добавляем бронирование (Один билет)
        bookingDAO.addBooking(1, 2, "reserved");

        // 📌 Добавляем несколько бронирований сразу (Групповая бронь)
        List<Integer> viewers = Arrays.asList(3, 4, 5);
        bookingDAO.addMultipleBookings(1, viewers);
    }
}
