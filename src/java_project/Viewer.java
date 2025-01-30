package java_project;

public class Viewer {
    private int id;
    private String name;
    private String email;

    // 📌 Конструктор
    public Viewer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // 📌 Геттеры
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // 📌 Красивый вывод объекта `Viewer`
    @Override
    public String toString() {
        return "Viewer{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
}
