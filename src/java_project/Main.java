package java_project;

public class Main {
    public static void main(String[] args) {
        BookingDAO bookingDAO = new BookingDAO();

        // ✅ Добавляем бронирование
        bookingDAO.addBooking(1, 1, "reserved");
        bookingDAO.addBooking(2, 2, "reserved");

        // ✅ Получаем все бронирования
        System.out.println("All Bookings:");
        for (Booking booking : bookingDAO.getAllBookings()) {
            System.out.println(booking);
        }

        // ✅ Обновляем бронирование
        bookingDAO.updateBooking(1, "canceled");

        // ✅ Удаляем бронирование
        bookingDAO.deleteBooking(2);
    }
}
