package types;

public class Reservation {
    private enum ReservationStatus{
        BOOKED,
        PAYMENT_IN_PROCESS,
        COMPLETED,
        ON_GOING
    }

    private double id;
    private ReservationStatus status;
    private boolean billingStatus;

    public User getUser() {
        return user;
    }

    private Vehicle vehicle;
    private User user;
    private int amount;

    public Reservation(ReservationStatus status, boolean billingStatus, Vehicle vehicle, User user) {
        this.id = Math.random();
        this.status = status;
        this.billingStatus = billingStatus;
        this.vehicle = vehicle;
        this.user = user;
    }

    public void setBillingStatus(boolean billingStatus){
        this.billingStatus = billingStatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
