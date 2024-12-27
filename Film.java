public class Film {
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
