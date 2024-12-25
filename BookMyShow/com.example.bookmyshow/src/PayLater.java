public class PayLater implements PaymentStrategy{
    @Override
    public int getPrice(PaymentMetadata metadata) {
        return 0;
    }
}
