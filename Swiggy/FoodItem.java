import java.util.*;

public class FoodItem {
    private int id;
    private String name;
    private List<AddOn> addOns;

    public FoodItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AddOn> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<AddOn> addOns) {
        this.addOns = addOns;
    }

    public void addAddOn(AddOn addOn){
        this.addOns.add(addOn);
    }
}
