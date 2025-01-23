public class Main {
    public static void main(String[] args) {
        BookingDAO bookingDAO = new BookingDAO();

        // 📌 Добавляем новое бронирование
        Booking newBooking = new Booking(1, 2, "reserved");
        bookingDAO.addBooking(newBooking);

        // 📌 Получаем все бронирования
        System.out.println("📌 Bookings in database:");
        for (Booking booking : bookingDAO.getAllBookings()) {
            System.out.println("Film ID: " + booking.getFilmId() +
                               ", Viewer ID: " + booking.getViewerId() +
                               ", Status: " + booking.getStatus());
        }

        // 📌 Обновляем статус бронирования
        bookingDAO.updateBookingStatus(1, "canceled");

        // 📌 Удаляем бронирование
        bookingDAO.deleteBooking(1);
    }
}
