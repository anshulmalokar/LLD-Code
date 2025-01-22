package manager;

import types.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderManager {
    private static OrderManager instance = null;
    private static final Lock lock = new ReentrantLock();
    private Map<String, Order> map = new HashMap<>();
    private OrderManager(){}

    public static OrderManager getInstance(){
        if(instance == null){
            try {
                lock.lock();
                if(instance == null){
                    return instance = new OrderManager();
                }
            }finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public void addOrder(Order order){
        this.map.put(order.getId()+"", order);
    }
}
