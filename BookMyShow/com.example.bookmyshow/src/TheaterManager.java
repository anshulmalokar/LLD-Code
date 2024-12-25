import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class TheaterManager {
    private static TheaterManager instance;
    private final static Lock lock = new ReentrantLock();
    private List<Theater> theaterList;
    private Map<Location, List<Theater>> locationTheaterMap = new HashMap();
    private TheaterManager() {}

    public void init(){
        Location location = new Location(10.00f, 10.00f, "Nagpur");
        Seat seat1 = new Seat(1);
        Seat seat2 = new Seat(2);
        Seat seat3 = new Seat(3);
        Seat seat4 = new Seat(4);
        Seat seat5 = new Seat(5);
        List<Seat> seats = new ArrayList<>();
        seats.add(seat1);
        seats.add(seat2);
        seats.add(seat3);
        seats.add(seat4);
        seats.add(seat5);
        Screen screen = new Screen("1", seats);
        List<Screen> screens = new ArrayList<>();
        screens.add(screen);
        List<Movie> movies = MovieManager.getInstance().getAllMovies();
        int id = 0;
        long time = 10;
        AtomicLong idLong = new AtomicLong(id);
        AtomicLong atomicLong = new AtomicLong(time);
        List<Show> shows = movies.stream().map(movie -> {
            long showId = idLong.addAndGet(1);
            long value = atomicLong.addAndGet(10);
            return new Show(showId,value, movie, movie.getDuration(), screen);
        }).toList();
        Theater theater = new Theater("A", location, screens, shows);
        addTheater(location, theater);
    }

    public static TheaterManager getInstance(){
        if(instance == null){
            lock.lock();
            try {
                if(instance == null){
                    return instance = new TheaterManager();
                }
            }finally {
                lock.unlock();
            }
        }
        return  instance;
    }

    public void addTheater(Location location, Theater theater){
        this.theaterList.add(theater);
        if(this.locationTheaterMap.get(location) == null){
            List<Theater> theaters = new ArrayList<>();
            theaters.add(theater);
            this.locationTheaterMap.put(location, theaters);
        }else{
            this.locationTheaterMap.get(location).add(theater);
        }
    }

    public List<Theater> getAllTheaters(){
        return this.theaterList;
    }

    public Optional<Theater> getTheater(String name){
        return theaterList.stream().filter(t -> t.getName().equals(name)).findFirst();
    }

    public boolean bookSeat(Theater theater, long showId, int seatNo, String userName)
            throws CustomException {
        User user = UserManager.getInstance().
                getUser(userName).orElseThrow(()->new CustomException(""));
        Show cshow = theater.checkShow(showId)
                .orElseThrow(() -> new CustomException("Incorrect Show Provided"));
        Screen screen = cshow.getScreen();
        Optional<Seat> seatOptional = screen.getSeats().stream()
                .filter(seat -> seat.getSeatNo() == seatNo)
                .findFirst();
        if (seatOptional.isPresent() && seatOptional.get().getStatus()) {
            return false;
        }
        Seat seat = seatOptional.get();
        Lock lock1 = seat.getLock();
        lock1.lock();
        try{
            if(seat.getStatus()){
                return false;
            }
            seat.setUser(user);
            seat.setStatus(true);
        }finally {
            lock1.unlock();
        }
        return true;
    }
}
