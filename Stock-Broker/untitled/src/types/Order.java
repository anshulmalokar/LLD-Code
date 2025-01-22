package types;

public class Order {
    private int id;
    private ORDER_TYPE type;
    private int quantity;
    private int price;
    private String stockName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ORDER_TYPE getType() {
        return type;
    }

    public void setType(ORDER_TYPE type) {
        this.type = type;
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

    public Order(int id, ORDER_TYPE type, int quantity, int price, String stockName) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.stockName = stockName;
    }
}
