import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DriverManager {
    private Map<String, Driver> mp = new HashMap<>();
    private static DriverManager instance;
    private final static Lock mtx = new ReentrantLock();

    private DriverManager(){

    }

    public static DriverManager getInstance(){
        if(instance == null){
            mtx.lock();
            try{
                if(instance == null){
                    return instance = new DriverManager();
                }
            }finally {
                mtx.unlock();
            }
        }
        return instance;
    }

    public void addDriver(Driver driver){
        mp.put(driver.getName(),driver);
    }

    public Map<String, Driver> getDrivers(){
        return this.mp;
    }

    public void changeStatus(Driver driver, boolean available){
        driver.setAvailable(available);
    }

}
