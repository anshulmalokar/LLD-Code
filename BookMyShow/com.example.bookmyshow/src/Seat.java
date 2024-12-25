import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Seat {
    private int seatNo;
    private boolean status;
    private User user;
    private final Lock lock = new ReentrantLock();

    public Lock getLock() {
        return lock;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Seat(int seatNo) {
        this.seatNo = seatNo;
        this.status = false;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
