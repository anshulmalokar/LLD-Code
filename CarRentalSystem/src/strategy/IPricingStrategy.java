package strategy;

import types.Location;
import types.Vehicle;

public interface IPricingStrategy {
    int calculatePrice(Location location, Vehicle vehicle);
}
