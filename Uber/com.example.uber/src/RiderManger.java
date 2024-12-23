import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RiderManger {
    private final Map<String, Rider> mp = new HashMap<>();
    private static RiderManger instance;
    private static final Lock lock = new ReentrantLock();

    private RiderManger(){}

    public static RiderManger getInstance(){
        if(instance == null){
            lock.lock();
            try {
                if(instance == null){
                    return instance = new RiderManger();
                }
            }finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public void addRider(Rider rider){
        mp.put(rider.getName(), rider);
    }

    public Map<String, Rider> getRiders(){
        return this.mp;
    }

}
