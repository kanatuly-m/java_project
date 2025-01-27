import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookingDAO bookingDAO = new BookingDAO();
        FilmDAO filmDAO = new FilmDAO();
        ViewerDAO viewerDAO = new ViewerDAO();

        // 📌 Добавляем фильмы
        filmDAO.addFilm("Inception", "Sci-Fi", 148);
        filmDAO.addFilm("Titanic", "Romance", 195);

        // 📌 Добавляем зрителей
        viewerDAO.addViewer("Alice Johnson", "alice@example.com");
        viewerDAO.addViewer("Bob Smith", "bob@example.com");

        // 📌 Выводим список фильмов
        System.out.println("📌 Available films:");
        filmDAO.getAllFilms().forEach(System.out::println);

        // 📌 Выводим список зрителей
        System.out.println("📌 Registered viewers:");
        viewerDAO.getAllViewers().forEach(System.out::println);

        // 📌 Групповое бронирование билетов
        List<Integer> viewers = Arrays.asList(1, 2); // ID зрителей
        bookingDAO.addMultipleBookings(1, viewers);

        // 📌 Выводим список бронирований
        System.out.println("📌 Bookings in database:");
        bookingDAO.getAllBookings().forEach(b -> 
            System.out.println("Film ID: " + b.getFilmId() +
                               ", Viewer ID: " + b.getViewerId() +
                               ", Status: " + b.getStatus())
        );
    }
}
