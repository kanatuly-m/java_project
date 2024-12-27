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
