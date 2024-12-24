import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderManager {
    private static OrderManager instance;
    private final static Lock mtx = new ReentrantLock();
    private Map<Integer, Order> mp = new HashMap<>();

    public Map<Integer, Order> getMp() {
        return mp;
    }

    public void createOrder(){
//        delegate task to food manager
        FoodManager foodManager = FoodManager.getInstance();

//        delegate task to delivery manger
        DeliveryManager deliveryManager = DeliveryManager.getInstance();
    }

    public void setMp(Map<Integer, Order> mp) {
        this.mp = mp;
    }

    public void addOrder(Order order){
        this.mp.put(order.getId(), order);
    }

    private OrderManager(){}

    public static OrderManager getInstance(){
        if(instance == null){
            mtx.lock();
            try {
                if(instance == null){
                    return instance = new OrderManager();
                }
            }finally {
                mtx.unlock();
            }
        }
        return instance;
    }
}
