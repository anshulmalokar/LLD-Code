public class Trip {
    private int id;
    private Rider rider;
    private Driver driver;
    private TripStatus status;
    private DriverMatchingStrategy driverMatchingStrategy;
    private PricingStrategy pricingStrategy;
    private float price;

    public Trip(
            Rider rider,
            Driver driver,
            TripStatus status,
            DriverMatchingStrategy driverMatchingStrategy,
            PricingStrategy pricingStrategy,
            float price
    ){
        this.driver = driver;
        this.rider = rider;
        this.status = status;
        this.driverMatchingStrategy = driverMatchingStrategy;
        this.pricingStrategy = pricingStrategy;
        this.price = price;
    }

    public void changeStatus(TripStatus status){
        this.status = status;
    }

    public String getDriverName(){
        return this.driver.getName();
    }

    public float getPrice(){
        return this.price;
    }

    public static enum TripStatus{
        STARTING,
        STOPPED,
        ONGOING,
        ENDED
    }
}
