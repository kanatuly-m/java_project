import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Film film1 = new Film("Interstellar", "Sci-Fi", 169);
        Film film2 = new Film("Titanic", "Romance", 195);
        Viewer viewer1 = new Viewer("Alice", 25);
        Viewer viewer2 = new Viewer("Bob", 30);
        Cinema cinema1 = new Cinema("Grand Cinema", 200);
        Cinema cinema2 = new Cinema("Cityplex", 150);

        System.out.println(film1);
        System.out.println(film2);
        System.out.println(viewer1);
        System.out.println(viewer2);
        System.out.println(cinema1);
        System.out.println(cinema2);

        System.out.println("Are films equal? " + film1.equals(film2));

        List<Film> films = Arrays.asList(film1, film2);
        films.sort((f1, f2) -> Integer.compare(f1.getDuration(), f2.getDuration()));
        System.out.println("Sorted films by duration: " + films);
    }
}
