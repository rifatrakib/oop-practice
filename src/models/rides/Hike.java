package models.rides;

import models.users.User;
import models.users.VehicleOwner;

public class Hike extends Ride {
    public Hike(User client, VehicleOwner vehicleOwner, double distance) {
        super(client, vehicleOwner, distance);
    }

    @Override
    public void acceptRide() {
        VehicleOwner vehicleOwner = getVehicleOwner();
        if (!vehicleOwner.isAvailable) {
            throw new IllegalArgumentException("Ride not available");
        }

        if (vehicleOwner.vehicle.getFarePerKm() <= 0) {
            throw new IllegalArgumentException("Driver does not provide this service");
        }

        super.acceptRide();
    }

    @Override
    public double calculateFare() {
        VehicleOwner vehicleOwner = getVehicleOwner();
        double distance = getDistance();
        return vehicleOwner.vehicle.getStartingFare() + (distance - 2) * vehicleOwner.vehicle.getFarePerKm();
    }
}
