package java_project;

public class Viewer extends Entity {
    private int id;
    private String name;

    public Viewer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Viewer{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
