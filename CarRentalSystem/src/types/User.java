package types;

import java.util.List;

public class User {
    private double id;
    private String name;
    private boolean drivingLicence;
    private List<Reservation> reservations;

    public List<Reservation> getReservations() {
        return reservations;
    }

    public User(long id, String name, boolean drivingLicence, List<Reservation> reservations) {
        this.id = Math.random();
        this.name = name;
        this.drivingLicence = drivingLicence;
        this.reservations = reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(boolean drivingLicence) {
        this.drivingLicence = drivingLicence;
    }
}
