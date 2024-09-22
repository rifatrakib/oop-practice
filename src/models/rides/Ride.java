package models.rides;

import abstracts.AbstractRide;
import models.users.User;
import models.users.VehicleOwner;

public class Ride extends AbstractRide {
    public Ride(User client, double distance) {
        super(client, distance);
    }

    public Ride(User client, int hours) {
        super(client, hours);
    }

    @Override
    public boolean canAcceptRide(VehicleOwner vehicleOwner) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double calculateFare() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void makePayment() {
        double fare = calculateFare();
        System.out.println("Payment in progress. Total fare: " + fare);
        User client = getClient();
        VehicleOwner vehicleOwner = getVehicleOwner();
        client.updateBalance(-fare);
        vehicleOwner.updateBalance(fare);
        System.out.println("Payment completed");
        System.out.println("Client balance: " + client.getBalance());
        System.out.println("Vehicle owner balance: " + vehicleOwner.getBalance());
    }
}
