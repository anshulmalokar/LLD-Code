package strategy.impl;

import strategy.IPricingStrategy;
import types.Location;
import types.Vehicle;

public class DefaultPricingStrategy implements IPricingStrategy {
    @Override
    public int calculatePrice(Location location, Vehicle vehicle) {
        System.out.println("Pirce calculated for the location : " + location + " " + vehicle.getName());
        return 100;
    }
}
