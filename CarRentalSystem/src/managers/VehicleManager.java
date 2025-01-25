package managers;

import types.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VehicleManager {
    private Map<Double, Vehicle> map = new HashMap<>();
    private static VehicleManager instance;
    private static  final Lock mtx = new ReentrantLock();
    private VehicleManager(){}

    public static VehicleManager getInstance(){
        if(instance == null){
            mtx.lock();
            try {
                if(instance == null){
                    return instance = new VehicleManager();
                }
            }finally {
                mtx.unlock();
            }
        }
        return instance;
    }
}
