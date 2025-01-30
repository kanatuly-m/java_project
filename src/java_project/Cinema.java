package java_project;

public class Cinema extends Entity {
    private String name;
    private int capacity;

    public Cinema(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cinema cinema = (Cinema) obj;
        return capacity == cinema.capacity && name.equals(cinema.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + capacity;
    }
}
