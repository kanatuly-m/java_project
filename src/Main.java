public class Main {
    public static void main(String[] args) {
        BookingDAO bookingDAO = new BookingDAO();
        Booking newBooking = new Booking(1, 2, "reserved");
        bookingDAO.addBooking(newBooking);

        System.out.println("📌 Bookings in database:");
        for (Booking booking : bookingDAO.getAllBookings()) {
            System.out.println("Film ID: " + booking.getFilmId() +
                               ", Viewer ID: " + booking.getViewerId() +
                               ", Status: " + booking.getStatus());
        }

        bookingDAO.updateBookingStatus(1, "canceled");

        bookingDAO.deleteBooking(1);
    }
}
