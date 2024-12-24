import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeliveryPartnerManager {
    private static DeliveryPartnerManager instance;
    private final static Lock mtx = new ReentrantLock();
    private Map<String, DeliveryPartner> mp = new HashMap<>();
    private DeliveryPartnerManager(){}

    public static DeliveryPartnerManager getInstance(){
        if(instance == null){
            mtx.lock();
            try {
                if(instance == null){
                    return instance = new DeliveryPartnerManager();
                }
            }finally {
                mtx.unlock();
            }
        }
        return instance;
    }

    public Map<String, DeliveryPartner> getMp() {
        return mp;
    }

    public void addPartner(DeliveryPartner deliveryPartner){
        this.mp.put(deliveryPartner.getName(), deliveryPartner);
    }
}
