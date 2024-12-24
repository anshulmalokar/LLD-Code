import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StrategyManager {
    private static StrategyManager instance;
    private static final Lock mtx = new ReentrantLock();

    private StrategyManager() {}

    public static StrategyManager getInstance(){
        if(instance == null){
            mtx.lock();
            try {
                if(instance == null)
                    return instance = new StrategyManager();
            }finally {
                mtx.unlock();
            }
        }
        return instance;
    }

    public PartnerMatchingStrategy getStrategy(){
        return new PartnerMatchingStrategy1();
    }
}
