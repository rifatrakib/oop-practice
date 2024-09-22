package abstracts;

import interfaces.PaymentInterface;
import interfaces.RideInterface;
import models.users.User;
import models.users.VehicleOwner;

public abstract class AbstractRide extends Identifier implements PaymentInterface, RideInterface {
    private final User client;
    private final VehicleOwner vehicleOwner;
    private double distance;
    private int hours;
    public boolean isCompleted = false;
    public float rating;

    public AbstractRide(User client, VehicleOwner vehicleOwner, double distance) {
        this.client = client;
        this.vehicleOwner = vehicleOwner;
        this.distance = distance;
    }

    public AbstractRide(User client, VehicleOwner vehicleOwner, int hours) {
        this.client = client;
        this.vehicleOwner = vehicleOwner;
        this.hours = hours;
    }

    @Override
    public void requestRide() {
        double fare = calculateFare();
        if (client.getBalance() < fare) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        System.out.println("Ride requested. Estimated fare: " + fare);
    }

    @Override
    public void acceptRide() {
        this.vehicleOwner.isAvailable = false;
        System.out.println("Ride accepted");
    }

    @Override
    public void rejectRide() {
        System.out.println("Ride rejected");
    }

    @Override
    public void cancelRide() {
        vehicleOwner.isAvailable = true;
        System.out.println("Ride cancelled");
    }

    @Override
    public void startRide() {
        System.out.println("Ride started");
    }

    @Override
    public void endRide() {
        vehicleOwner.isAvailable = true;
        isCompleted = true;
        makePayment();
        System.out.println("Ride ended");
    }

    public User getClient() {
        return client;
    }

    public VehicleOwner getVehicleOwner() {
        return vehicleOwner;
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

    public abstract double calculateFare();
    public abstract void makePayment();
}
