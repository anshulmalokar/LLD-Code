package types;

import java.util.List;

public class Store {
    private double id;
    private String name;

    public double getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Store(String name, Location location, List<Vehicle> vehicles, List<Reservation> reservations) {
        this.id = Math.random();
        this.name = name;
        this.location = location;
        this.vehicles = vehicles;
        this.reservations = reservations;
    }

    private Location location;
    private List<Vehicle> vehicles;
    private List<Reservation> reservations;
}
