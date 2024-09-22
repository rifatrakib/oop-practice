package abstracts;

import interfaces.PaymentInterface;
import models.users.User;
import models.users.VehicleOwner;

public abstract class AbstractRide extends Identifier implements PaymentInterface {
    private final User client;
    private VehicleOwner vehicleOwner;
    private double distance;
    private int hours;
    public boolean isCompleted = false;
    public float rating;

    public AbstractRide(User client, double distance) {
        this.client = client;
        this.distance = distance;
    }

    public AbstractRide(User client, int hours) {
        this.client = client;
        this.hours = hours;
    }

    public void setVehicleOwner(VehicleOwner vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public VehicleOwner getVehicleOwner() {
        return vehicleOwner;
    }

    public void startRide() {
        System.out.println("Ride started");
    }

    public void endRide() {
        vehicleOwner.isAvailable = true;
        isCompleted = true;
        makePayment();
        System.out.println("Ride ended");
    }

    public User getClient() {
        return client;
    }

    public double getDistance() {
        return distance;
    }

    public int getHours() {
        return hours;
    }

    public void setRating(float rating) {
        this.rating = rating;
        vehicleOwner.setRating(rating);
    }

    public double estimateFare(int ratePerHour) {
        return hours * ratePerHour;
    }

    public double estimateFare(double farePerKm, double startingFare) {
        return startingFare + (distance - 2) * farePerKm;
    }

    public abstract boolean canAcceptRide(VehicleOwner vehicleOwner);
    public abstract double calculateFare();
    public abstract void makePayment();
}
