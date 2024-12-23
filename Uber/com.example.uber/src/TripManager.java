import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TripManager {
    private Map<String, Trip> mp = new HashMap<>();
    private static TripManager instance;
    private static Lock mtx = new ReentrantLock();
    private TripManager(){}

    public static TripManager getInstance(){
        if(instance == null){
            mtx.lock();
            try {
                if(instance == null){
                    return instance = new TripManager();
                }
            }finally {
                mtx.unlock();
            }
        }
        return  instance;
    }

    public Trip createTrip(Rider rider, Location src, Location dest){
        TripMetaData tripMetaData = new TripMetaData(src, dest, rider.getRating());

        StrategyManager manager = StrategyManager.getInstance();
        DriverMatchingStrategy driverMatchingStrategy = manager.determineDriverMatchingStrategy(tripMetaData);
        PricingStrategy pricingStrategy = manager.determinPricingStrategy(tripMetaData);

        Driver driver = driverMatchingStrategy.matchDriver(tripMetaData);
        driver.setAvailable(false);

        Trip trip = new Trip(rider, driver,
                Trip.TripStatus.STARTING,
                driverMatchingStrategy,pricingStrategy, pricingStrategy.getPrice(tripMetaData));
        mp.put( driver.getName() + "" + rider.getName(), trip);
        return trip;
    }

    public void updateStatus(Trip trip,Trip.TripStatus status){

    }

}