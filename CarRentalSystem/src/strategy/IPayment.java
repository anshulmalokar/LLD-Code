package strategy;

import types.Bill;
import types.Reservation;

public interface IPayment extends AutoCloseable {
    void makePaymet(Reservation reservation);
}
