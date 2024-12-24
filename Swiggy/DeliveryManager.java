import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeliveryManager {
    private static DeliveryManager instance;
    private final static Lock mtx = new ReentrantLock();
    private DeliveryManager(){}

    public static DeliveryManager getInstance(){
        if(instance == null){
            mtx.lock();
            try {
                if(instance == null){
                    return instance = new DeliveryManager();
                }
            }finally {
                mtx.unlock();
            }
        }
        return instance;
    }
}
