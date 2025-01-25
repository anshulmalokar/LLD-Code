package managers;

import types.Location;
import types.Store;
import types.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class StoreManager {
    private Map<Double, List<Store>> map = new HashMap<>();
    private Map<Location, List<Store>> locationStoreMap = new HashMap<>();
    private static StoreManager instance;
    private static  final Lock mtx = new ReentrantLock();
    private StoreManager(){}

    public static StoreManager getInstance(){
        if(instance == null){
            mtx.lock();
            try {
                if(instance == null){
                    return instance = new StoreManager();
                }
            }finally {
                mtx.unlock();
            }
        }
        return instance;
    }

    public List<Vehicle> getVehicles(Location location){
        List<Store> store =  locationStoreMap.get(location).stream().filter(s -> s.getLocation() == location)
                .collect(Collectors.toList());
        return store.get(0).getVehicles();
    }

    public Store getStore(double storeId) {
        Store store = this.map.get(storeId).get(0);
        return store;
    }
}
