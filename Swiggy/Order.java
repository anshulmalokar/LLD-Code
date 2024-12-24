public class Order {
    private int id;
    private Restraunt restraunt;
    private DeliveryPartner deliveryPartner;

    public Order(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Restraunt getRestraunt() {
        return restraunt;
    }

    public void setRestraunt(Restraunt restraunt) {
        this.restraunt = restraunt;
    }

    public DeliveryPartner getDeliveryPartner() {
        return deliveryPartner;
    }

    public void setDeliveryPartner(DeliveryPartner deliveryPartner) {
        this.deliveryPartner = deliveryPartner;
    }

    public enum ORDERSTATUS{
        preparing,
        dispatched,
        delivered
    }

}
