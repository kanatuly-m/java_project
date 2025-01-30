package java_project;

public class Film {
    private int id;
    private String title;
    private String genre;
    private int duration;

    // 📌 Конструктор
    public Film(int id, String title, String genre, int duration) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    // 📌 Геттеры (если понадобятся)
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    // 📌 Красивый вывод объекта `Film`
    @Override
    public String toString() {
        return "Film{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", genre='" + genre + '\'' +
               ", duration=" + duration +
               '}';
    }
}
