public class PartnerMatchingStrategy2 implements PartnerMatchingStrategy{
    @Override
    public DeliveryPartner matchDeliveryPartner(DeliveryMetadata deliveryMetadata) {
        DeliveryPartnerManager deliveryPartnerManager = DeliveryPartnerManager.getInstance();
//        Run some algorithm and decide which partner you will need to return
        return deliveryPartnerManager.getMp().get("A");
    }
}
