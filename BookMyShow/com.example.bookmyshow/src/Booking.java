public class Booking {
    private int id;
    private User user;
    private Movie movie;
    private Theater theater;
    private Seat seat;
    private Show show;
    private Screen screen;
    private int price;
    private BookingStatus status;

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Booking(User user, Movie movie, Theater theater, Seat seat, Show show, int price, Screen screen) {
        this.user = user;
        this.movie = movie;
        this.theater = theater;
        this.seat = seat;
        this.show = show;
        this.price = price;
        this.screen = screen;
        this.status = BookingStatus.PENDING;
    }

    public enum BookingStatus {
        PENDING,       // Booking is awaiting confirmation
        CONFIRMED,     // Booking has been confirmed
        CANCELLED,     // Booking has been cancelled
        COMPLETED,     // Booking has been completed
        NO_SHOW;       // Customer did not show up
    }
}

