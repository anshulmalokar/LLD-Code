//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from the UBER Application");
//        Create Some Riders
        Rider rider = new Rider("A");
        Rider rider1 = new Rider("B");
        Rider rider2= new Rider("C");
        RiderManger riderManger = RiderManger.getInstance();
        riderManger.addRider(rider);
        riderManger.addRider(rider1);
        riderManger.addRider(rider2);

//        Create Drivers
        Driver driver = new Driver("A");
        Driver driver2 = new Driver("B");
        Driver driver3 = new Driver("C");
        DriverManager driverManager = DriverManager.getInstance();
        driverManager.addDriver(driver);
        driverManager.addDriver(driver2);
        driverManager.addDriver(driver3);

        System.out.println("Drivers ->" + driverManager.getDrivers());
        System.out.println("Riders -> " + riderManger.getRiders());

//      Now the rider will come and ask for a trip
        TripManager tripManager = TripManager.getInstance();
        Trip trip =
                tripManager.createTrip(rider, new Location(10.00, 10.00), new Location(20.00, 20.00));
        System.out.println("Driver -> " + trip.getDriverName());
        System.out.println("Price -> " + trip.getPrice());
        System.out.println("Ending from the UBER Application");
    }
}