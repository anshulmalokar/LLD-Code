import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        UserManager.getInstance().init();
        MovieManager.getInstance().init();
        TheaterManager.getInstance().init();
        executorService.submit(() -> {
            boolean completion = BookingManager.getInstance().startProces("A","A",1,1);
            System.out.println("Task 1 completion status: " + completion);
        });
        executorService.submit(() -> {
            boolean completion = BookingManager.getInstance().startProces("A","A",1,1);
            System.out.println("Task 1 completion status: " + completion);
        });
        executorService.shutdown();
        System.out.println("Thanks for booking");
    }
}