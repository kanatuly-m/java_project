package java_project;

public class Booking {
    private int id;
    private Film film;
    private Viewer viewer;
    private String status;

    // 📌 Конструктор
    public Booking(int id, Film film, Viewer viewer, String status) {
        this.id = id;
        this.film = film;
        this.viewer = viewer;
        this.status = status;
    }

    // 📌 Геттеры
    public int getId() { return id; }
    public Film getFilm() { return film; }
    public Viewer getViewer() { return viewer; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Booking{" +
               "id=" + id +
               ", film=" + film.getTitle() +
               ", viewer=" + viewer.getName() +
               ", status='" + status + '\'' +
               '}';
    }
}
