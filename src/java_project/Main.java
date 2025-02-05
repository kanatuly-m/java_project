package java_project;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ViewerDAO viewerDAO = new ViewerDAO();
        FilmDAO filmDAO = new FilmDAO();
        BookingDAO bookingDAO = new BookingDAO();

        // ✅ Добавляем тестовые данные
        System.out.println("📌 Добавление зрителей...");
        viewerDAO.addViewer("John Doe");
        viewerDAO.addViewer("Alice Smith");

        System.out.println("📌 Добавление фильмов...");
        filmDAO.addFilm("Inception", "Sci-Fi", 148);
        filmDAO.addFilm("Interstellar", "Sci-Fi", 169);

        // ✅ Выводим всех зрителей
        System.out.println("\n📌 Все зрители:");
        List<Viewer> viewers = viewerDAO.getAllViewers();
        for (Viewer v : viewers) {
            System.out.println(v);
        }

        // ✅ Выводим все фильмы
        System.out.println("\n📌 Все фильмы:");
        List<Film> films = filmDAO.getAllFilms();
        for (Film f : films) {
            System.out.println(f);
        }

        // ✅ Добавляем бронирование
        if (!films.isEmpty() && !viewers.isEmpty()) {
            System.out.println("\n📌 Добавление бронирования...");
            bookingDAO.addBooking(films.get(0), viewers.get(0), "reserved");
        }

        // ✅ Вывод всех бронирований
        System.out.println("\n📌 Все бронирования:");
        List<Booking> bookings = bookingDAO.getAllBookings(filmDAO, viewerDAO);
        for (Booking b : bookings) {
            System.out.println(b);
        }

        System.out.println("\n✅ Программа успешно завершена!");
    }
}
