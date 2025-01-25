package application;

import managers.StoreManager;
import managers.UserManager;
import managers.VehicleManager;
import process.BilingProcess;
import strategy.IPayment;
import strategy.impl.DefaultPaymentStrategy;
import types.*;

import java.util.List;

public class RentalApplication {
    public List<Vehicle> getVehicle(double userId) {
        User user = UserManager.getInstance().getUser(userId);
        return StoreManager.getInstance().getVehicles(new Location("","10"));
    }

    public Bill bookVehicle(double userId, double storeId, double vehicleId){
        User user = UserManager.getInstance().getUser(userId);
        Store store = StoreManager.getInstance().getStore(storeId);
        Vehicle vehicle = null;
        Reservation reservation = createResercation(user, store, vehicle);
        BilingProcess bilingProcess = new BilingProcess();
        Bill bill = bilingProcess.generateBill(reservation);
        return bill;
    }

    private Reservation createResercation(User user, Store store, Vehicle vehicle) {
    }
}
