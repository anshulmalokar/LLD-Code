public class Show {
    private long id;
    private long time;
    private long showDuration;
    private Movie movie;
    private Screen screen;

    public Show(long id,long time, Movie movie, long showDuration, Screen screen) {
        this.time = time;
        this.movie = movie;
        this.showDuration = showDuration;
        this.screen = screen;
    }

    public long getId(){
        return this.id;
    }

    public Screen getScreen() {
        return screen;
    }
}
