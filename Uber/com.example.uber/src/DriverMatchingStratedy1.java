public class DriverMatchingStratedy1 implements DriverMatchingStrategy{
    @Override
    public Driver matchDriver(TripMetaData tripMetaData) {
        DriverManager driverManager = DriverManager.getInstance();
        if(driverManager.getDrivers().isEmpty()){
            System.out.println("No drivers are currently listed");
        }
//        here there will be one algorithm to get the driver
//        Based on the tripMetaData the driver will be assigned
        Driver d = driverManager.getDrivers().get("A");
        return d;
    }
}
