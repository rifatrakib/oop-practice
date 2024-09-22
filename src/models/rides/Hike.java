package models.rides;

import models.users.User;
import models.users.VehicleOwner;

public class Hike extends Ride {
    public Hike(User client, double distance) {
        super(client, distance);
    }

    @Override
    public double calculateFare() {
        VehicleOwner vehicleOwner = getVehicleOwner();
        double distance = getDistance();
        return vehicleOwner.vehicle.getStartingFare() + (distance - 2) * vehicleOwner.vehicle.getFarePerKm();
    }

    @Override
    public boolean canAcceptRide(VehicleOwner vehicleOwner) {
        double farePerKm = vehicleOwner.vehicle.getFarePerKm();
        double startingFare = vehicleOwner.vehicle.getStartingFare();
        if (estimateFare(farePerKm, startingFare) > getClient().getBalance()) {
            throw new IllegalArgumentException("Client does not have enough balance");
        }

        return true;
    }
}
