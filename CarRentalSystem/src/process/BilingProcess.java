package process;

import strategy.IPayment;
import strategy.impl.DefaultPaymentStrategy;
import types.Bill;
import types.Reservation;

public class BilingProcess {
    public Bill generateBill(Reservation reservation){
        try(IPayment payment = new DefaultPaymentStrategy();) {
            payment.makePaymet(reservation);
            return new Bill(reservation, false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
