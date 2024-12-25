import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StrategyManager {
    private static StrategyManager instance;
    private final static Lock mtx = new ReentrantLock();

    public static StrategyManager getInstance(){
        if(instance == null){
            mtx.lock();
            try {
                return instance = new StrategyManager();
            }finally {
                mtx.unlock();
            }
        }
        return instance;
    }

    public PaymentStrategy getStrategy(){
        return new UPI();
    }
}
