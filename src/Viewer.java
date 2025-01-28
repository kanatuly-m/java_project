
public class Viewer extends Entity {
    private String name;
    private int age;

    public Viewer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Viewer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Viewer viewer = (Viewer) obj;
        return age == viewer.age && name.equals(viewer.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }
}
