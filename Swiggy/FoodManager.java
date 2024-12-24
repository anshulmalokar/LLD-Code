import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FoodManager {
    private static FoodManager instance;
    private final static Lock mtx = new ReentrantLock();
    private FoodManager(){}

    public static FoodManager getInstance(){
        if(instance == null){
            mtx.lock();
            try {
                if(instance == null){
                    return instance = new FoodManager();
                }
            }finally {
                mtx.unlock();
            }
        }
        return instance;
    }

    public void preareOrder(){

    }
}
