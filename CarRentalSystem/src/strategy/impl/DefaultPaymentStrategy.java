package strategy.impl;

import strategy.IPayment;
import types.Bill;
import types.Reservation;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DefaultPaymentStrategy implements IPayment {
    private ExecutorService executorService;
    public DefaultPaymentStrategy(){
        executorService = Executors.newFixedThreadPool(1);
    }

    @Override
    public void makePaymet(Reservation reservation) {
        int amount = reservation.getAmount();
        executorService.submit(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Payment done for " + reservation.getAmount() + " by " + reservation.getUser());
                return new Bill(reservation, true);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void close() throws Exception {
        this.executorService.shutdown();
    }
}
