package models.rides;

import models.users.User;
import models.users.VehicleOwner;

public class Rent extends Ride {
    public Rent(User client, VehicleOwner vehicleOwner, int hours) {
        super(client, vehicleOwner, hours);
    }

    @Override
    public void acceptRide() {
        VehicleOwner vehicleOwner = getVehicleOwner();
        if (!vehicleOwner.isAvailable) {
            throw new IllegalArgumentException("Ride not available");
        }

        if (vehicleOwner.getRatePerHour() <= 0) {
            throw new IllegalArgumentException("Driver does not provide this service");
        }

        super.acceptRide();
    }

    @Override
    public double calculateFare() {
        VehicleOwner vehicleOwner = getVehicleOwner();
        int hours = getHours();
        return hours * vehicleOwner.getRatePerHour();
    }
}
