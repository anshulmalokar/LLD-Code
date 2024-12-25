import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UserManager {
    private static UserManager instance;
    private final static Lock mtx = new ReentrantLock();
    private Map<String, User> mp = new HashMap<>();
    private UserManager(){}

    public static UserManager getInstance(){
        if(instance == null){
            mtx.lock();
            try {
                if(instance == null){
                    return instance = new UserManager();
                }
            }finally {
                mtx.unlock();
            }
        }
        return instance;
    }

    public void addUser(User user){
        this.mp.put(user.getName(), user);
    }

    public Optional<User> getUser(String name){
        return Optional.ofNullable(mp.get(name));
    }

    public void init(){
        Location location = new Location(10.00f, 10.00f, "Nagpur");
        User user1 = new User(location, "A");
        User user2 = new User(location, "B");
        User user3 = new User(location, "C");
        addUser(user1);
        addUser(user2);
        addUser(user3);
    }
}
