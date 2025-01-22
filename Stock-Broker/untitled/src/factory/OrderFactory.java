package factory;

import metadata.OrderMetaData;
import types.ORDER_TYPE;
import types.Order;

public class OrderFactory {
    public Order createOrder(OrderMetaData orderMetaData){
        if(orderMetaData.getType() == ORDER_TYPE.BUY){
            Order order = new Order(generateRamdomId(), orderMetaData.getType(),
                    orderMetaData.getQuantity(), orderMetaData.getPrice(), orderMetaData.getStockName());
            return order;
        }else{
            Order order = new Order(generateRamdomId(), orderMetaData.getType(),
                    orderMetaData.getQuantity(), orderMetaData.getPrice(), orderMetaData.getStockName());
            return order;
        }
    }

    private int generateRamdomId(){
        return (int)Math.random();
    }
}
