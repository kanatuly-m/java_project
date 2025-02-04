package java_project;

public class Main {
    public static void main(String[] args) {
        ViewerDAO viewerDAO = new ViewerDAO();
        FilmDAO filmDAO = new FilmDAO();
        BookingDAO bookingDAO = new BookingDAO();

        // ✅ Добавляем зрителей
        viewerDAO.addViewer("John Doe");
        viewerDAO.addViewer("Alice Smith");

        // ✅ Получаем всех зрителей
        for (Viewer v : viewerDAO.getAllViewers()) {
            System.out.println(v);
        }

        // ✅ Добавляем фильм
        filmDAO.addFilm("Inception", "Sci-Fi", 148);

        // ✅ Получаем все фильмы
        for (Film f : filmDAO.getAllFilms()) {
            System.out.println(f);
        }

        // ✅ Бронирование билетов
        bookingDAO.addBooking(filmDAO.getAllFilms().get(0), viewerDAO.getAllViewers().get(0), "reserved");
    }
}
