package facade;

import metadata.OrderMetaData;
import processor.OrderProcessor;

public class StockBrokerApplication {
    public StockBrokerApplication(){

    }
    public void createOrder(OrderMetaData orderMetaData){
        OrderProcessor.getInstance().createOrder(orderMetaData);
    }
}
