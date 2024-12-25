import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BookingManager {
    List<Booking> bookingList;
    Map<User, Booking> userBookingMap;
    Map<Theater, Booking> theaterBookingMap;
    Map<Movie, Booking> movieBookingMap;
    private static BookingManager instance;
    private final static Lock lock = new ReentrantLock();
    private BookingManager(){}

    public static BookingManager getInstance(){
        if(instance == null){
            lock.lock();
            try {
                if(instance == null){
                    return instance = new BookingManager();
                }
            }finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public boolean startProces(String userName,
                            String theaterName,
                            int seatNo,
                            long showId){
        try{
            User user = UserManager.getInstance().getUser(userName)
                    .orElseThrow(() -> new CustomException("User Not Found"));
            Theater theater = TheaterManager.getInstance().getTheater(theaterName)
                    .orElseThrow(() -> new CustomException("Theater Not Found"));

            PaymentStrategy strategy = StrategyManager.getInstance().getStrategy();
            int price = strategy.getPrice(new PaymentMetadata());
            boolean statusOfSeat = TheaterManager.getInstance().bookSeat(
                    theater,
                    showId,
                    seatNo,
                    userName
            );
//            Will need to resolve this bug
            Booking booking = new Booking(
                  user,
                  "A",
                  theater,
                  seatNo,
                  showId,
                  screenNo,
                  price,
                  Booking.BookingStatus.PENDING
            );
            Thread.sleep(1000l); // This thread is for allowing user to do the payment
            booking.setStatus(Booking.BookingStatus.CONFIRMED);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}

//            Check is this show is correct
//            Check if the seats are available
//            Check if this particular seat is already booked or not
//            Handle concurrency