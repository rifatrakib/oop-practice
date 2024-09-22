package models.rides;

import models.users.User;
import models.users.VehicleOwner;

public class Rent extends Ride {
    public Rent(User client, int hours) {
        super(client, hours);
    }

    @Override
    public double calculateFare() {
        VehicleOwner vehicleOwner = getVehicleOwner();
        int hours = getHours();
        return hours * vehicleOwner.getRatePerHour();
    }

    @Override
    public boolean canAcceptRide(VehicleOwner vehicleOwner) {
        if (!vehicleOwner.canAcceptHourlyRides()) {
            throw new IllegalArgumentException("Driver does not provide this service");
        }

        if (estimateFare(vehicleOwner.getRatePerHour()) > getClient().getBalance()) {
            throw new IllegalArgumentException("Client does not have enough balance");
        }

        return true;
    }
}
