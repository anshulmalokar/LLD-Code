import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MovieManager {
    private static MovieManager instance;
    private List<Movie> movieList;
    private Map<Location, List<Movie>> moiveLocationMapping;
    private final static Lock mtx = new ReentrantLock();
    private MovieManager() {}

    public void init(){
        Movie movie1 = new Movie("A", 1000L);
        Movie movie2 = new Movie("A", 1000L);
        Movie movie3 = new Movie("A", 1000L);
        Location location = new Location(10.00f, 10.00f, "Nagpur");
        addMovie(movie1);
        addMovie(movie2);
        addMovie(movie3);
        addMovie(movie1, location);
        addMovie(movie2, location);
        addMovie(movie3, location);
    }

    public static MovieManager getInstance(){
        if(instance == null){
            mtx.lock();
            try {
                if(instance == null){
                    return instance = new MovieManager();
                }
            }finally {
                mtx.unlock();
            }
        }
        return instance;
    }

    public void addMovie(Movie movie){
        this.movieList.add(movie);
    }

    public void addMovie(Movie movie, Location location){
        if(moiveLocationMapping.get(location) == null){
            List<Movie> mov = new ArrayList<>();
            mov.add(movie);
            moiveLocationMapping.put(location, mov);
        }else{
            moiveLocationMapping.get(location).add(movie);
        }
    }

    public List<Movie> getAllMovies(){
        return this.movieList;
    }

    public List<Movie> getMoviesByLocation(Location location){
        List<Movie> movieByLocation = moiveLocationMapping.get(location);
        if( movieByLocation == null || movieByLocation.isEmpty()){
            return new ArrayList<>();
        }
        return movieByLocation;
    }
}
