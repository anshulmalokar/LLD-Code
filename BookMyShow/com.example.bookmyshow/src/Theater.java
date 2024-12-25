import java.util.List;
import java.util.Optional;

public class Theater {
    private String name;
    private Location location;
    List<Screen> screens;
    List<Show> shows;

    public Theater(String name, Location location, List<Screen> screens, List<Show> shows) {
        this.name = name;
        this.location = location;
        this.screens = screens;
        this.shows = shows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<Show> checkShow(long showid){
        return this.shows.stream().filter(s -> s.getId() == showid).findFirst();
    }

}
