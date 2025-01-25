package types;

public class Bill {
    private Reservation reservation;
    private boolean paidStatus;
    public Bill(Reservation reservation, boolean paidStatus){
        this.paidStatus = paidStatus;
        this.reservation = reservation;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public boolean isPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(boolean paidStatus) {
        this.paidStatus = paidStatus;
    }
}
