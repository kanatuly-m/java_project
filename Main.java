class Film {
    private String title;
    private String genre;
    private int duration;
    public Film(String title,String genre,int duration) {
        this.title=title;
        this.genre=genre;
        this.duration=duration;
    }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public void displayFilmInfo() {
        System.out.println("Film: "+title+" | Genre: "+genre+" | Duration: "+duration+" mins");
    }
}
class Viewer {
    private String name;
    private int age;
    public Viewer(String name,int age) {
        this.name=name;
        this.age=age;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name=name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age=age; }
    public void displayViewerInfo() {
        System.out.println("Viewer: "+name+" | Age: "+age);
    }
}
class Cinema {
    private String name;
    private int capacity;
    public Cinema(String name, int capacity) {
        this.name=name;
        this.capacity=capacity;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name=name; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity=capacity; }
    public void displayCinemaInfo() {
        System.out.println("Cinema: "+name+" | Capacity: "+capacity);
    }
}
public class Main {
    public static void main(String[] args) {
        Film film1 = new Film("Interstellar", "Epic scienceiction drama", 169);
        Film film2 = new Film("Titanic", "Romance", 195);
        Viewer viewer1=new Viewer("Islana",17);
        Viewer viewer2=new Viewer("Merey", 17);
        Cinema cinema1=new Cinema("Chaplin", 200);
        Cinema cinema2=new Cinema("Kinopark", 150);
        System.out.println("** Films **");
        film1.displayFilmInfo();
        film2.displayFilmInfo();
        System.out.println("\n** Viewers **");
        viewer1.displayViewerInfo();
        viewer2.displayViewerInfo();
        System.out.println("\n** Cinemas **");
        cinema1.displayCinemaInfo();
        cinema2.displayCinemaInfo();
        System.out.println("\nComparing Films:");
        if (film1.getDuration() > film2.getDuration()) {
            System.out.println(film1.getTitle()+" is longer than "+film2.getTitle());
        } else if (film1.getDuration() < film2.getDuration()) {
            System.out.println(film2.getTitle()+" is longer than "+film1.getTitle());
        } else {
            System.out.println("Both films have the same duration.");
        }
    }
}
