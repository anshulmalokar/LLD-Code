package managers;

import types.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UserManager {
    private Map<Double, User> map = new HashMap<>();
    private static UserManager instance = null;
    private static final Lock lock = new ReentrantLock();
    private UserManager(){
    }
    public static UserManager getInstance(){
        if(instance == null){
            lock.lock();
            try{
                if(instance == null){
                    return instance = new UserManager();
                }
            }finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public User getUser(double userId){
        return this.map.get(userId);
    }
}
