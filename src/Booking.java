public class Booking {
    private int id;
    private int filmId;
    private int viewerId;
    private String status;

    public Booking(int filmId, int viewerId, String status) {
        this.filmId = filmId;
        this.viewerId = viewerId;
        this.status = status;
    }

    public int getId() { return id; }
    public int getFilmId() { return filmId; }
    public int getViewerId() { return viewerId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
