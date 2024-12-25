import java.util.ArrayList;
import java.util.List;

public class Screen {
    private String name;
    private final int limit = 5;
    private List<Seat> seats = new ArrayList<>(limit);

    public Screen(String name, List<Seat> seats) {
        this.name = name;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public String getName() {
        return name;
    }
}
