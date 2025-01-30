package java_project;

public class Booking {
    private int id;
    private int filmId;
    private int viewerId;
    private String status;

    // 📌 Конструктор для создания объектов Booking из базы данных
    public Booking(int id, int filmId, int viewerId, String status) {
        this.id = id;
        this.filmId = filmId;
        this.viewerId = viewerId;
        this.status = status;
    }

    // 📌 Конструктор без ID (для новых записей)
    public Booking(int filmId, int viewerId, String status) {
        this.filmId = filmId;
        this.viewerId = viewerId;
        this.status = status;
    }

    // 📌 Геттеры и сеттеры
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getFilmId() { return filmId; }
    public void setFilmId(int filmId) { this.filmId = filmId; }

    public int getViewerId() { return viewerId; }
    public void setViewerId(int viewerId) { this.viewerId = viewerId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
