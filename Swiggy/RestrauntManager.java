import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RestrauntManager {
    private static RestrauntManager instance;
    private final static Lock mtx = new ReentrantLock();
    private RestrauntManager(){}

    public static RestrauntManager getInstance(){
        if(instance == null){
            mtx.lock();
            try {
                if(instance == null){
                    return instance = new RestrauntManager();
                }
            }finally {
                mtx.unlock();
            }
        }
        return instance;
    }
}
