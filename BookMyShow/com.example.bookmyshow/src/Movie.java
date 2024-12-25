public class Movie {
    private int id;
    private String name;
    private long duration;
    private float rating;

    public Movie(String name, long duration) {
        this.name = name;
        this.duration = duration;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
