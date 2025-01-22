package processor;

import factory.OrderFactory;
import manager.OrderManager;
import metadata.OrderMetaData;
import proxy.ExchangeConnection;
import types.Order;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderProcessor {
    private static OrderProcessor instance;
    private static final Lock mtx = new ReentrantLock();
    private OrderProcessor(){}
    public static OrderProcessor getInstance(){
        if(instance == null){
            try{
                mtx.lock();
                if(instance == null){
                    return  instance = new OrderProcessor();
                }
            }finally {
                mtx.unlock();
            }
        }
        return instance;
    }

    public void createOrder(OrderMetaData orderMetaData){
        try{
            OrderFactory orderFactory = new OrderFactory();
            Order order = orderFactory.createOrder(orderMetaData);
            System.out.println("Order Created : " + order.getId());
            OrderManager.getInstance().addOrder(order);
            ExchangeConnection.getInstance().addOrder(order);
            System.out.println("Process Done : " + order.getId());
        }catch (Exception e){

        }
    }
}
