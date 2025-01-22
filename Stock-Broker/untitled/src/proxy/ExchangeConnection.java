package proxy;

import metadata.OrderMetaData;
import types.Order;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExchangeConnection {
    private static ExchangeConnection instance;
    private static  final Lock lock = new ReentrantLock();
    private ExecutorService executorService;
    private ExchangeConnection(){
        executorService = Executors.newFixedThreadPool(4);
    }
    public static ExchangeConnection getInstance(){
        if(instance == null){
            try {
                lock.lock();
                if(instance == null){
                    return instance = new ExchangeConnection();
                }
            }finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public void addOrder(Order order){
        executorService.submit(() -> {
            try{
                Thread.sleep(5000);
                System.out.println("Rpc call made for : " + order.getId());
            }catch (Exception e){

            }
        });
    }
}
