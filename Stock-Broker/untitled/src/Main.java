//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }
}

// Building the low level design for a Stock Broker Application
// Designing for create order and notify order
// Actor
//   User
// Application flow
//  - Client -> Main Class
//  - Facade -> StockBrokerApplication
//  - Types  -> Order, Stock
//  - Manager -> OrderManager, StockManager
//  - Processor -> OrderProcessor
//  - MetaData -> OrderMetaData, StockMetaData  ( Might be needed for sharing the data between classes )
//  - Factory -> OrderFactory
//  - Proxy -> ExchangeConnection
//  Flow of the application
//  - Client -> addOrder to the StockBrokerApplication
//           -> StockBrokerApplication will be contacting to the OrderProcessor and delegate the process
//           -> of order creation
//           -> OrderProcessor will be creating an order using OrderFactory and add this in the OrderManager
//           -> For Any further us
