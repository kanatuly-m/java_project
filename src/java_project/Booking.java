package java_project;

public class Booking {
    private int id;
    private int filmId;
    private int viewerId;
    private String status;

    // 📌 Конструктор
    public Booking(int id, int filmId, int viewerId, String status) {
        this.id = id;
        this.filmId = filmId;
        this.viewerId = viewerId;
        this.status = status;
    }

    // 📌 Геттеры
    public int getId() {
        return id;
    }

    public int getFilmId() {
        return filmId;
    }

    public int getViewerId() {
        return viewerId;
    }

    public String getStatus() {
        return status;
    }

    // 📌 Красивый вывод объекта `Booking`
    @Override
    public String toString() {
        return "Booking{" +
               "id=" + id +
               ", filmId=" + filmId +
               ", viewerId=" + viewerId +
               ", status='" + status + '\'' +
               '}';
    }
}
