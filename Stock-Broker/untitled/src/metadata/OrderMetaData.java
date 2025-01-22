package metadata;

import types.Order;
import types.ORDER_TYPE;
public class OrderMetaData {

    private ORDER_TYPE type;

    public ORDER_TYPE getType() {
        return type;
    }

    public void setType(ORDER_TYPE type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    private int quantity;
    private int price;
    private String stockName;

    public OrderMetaData(ORDER_TYPE type, int quantity, int price, String stockName) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.stockName = stockName;
    }
}
