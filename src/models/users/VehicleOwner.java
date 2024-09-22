package models.users;

import models.vehicles.Vehicle;

public class VehicleOwner extends User {
    public Vehicle vehicle;
    private int ratePerHour;
    private float rating;
    private int totalTrips = 0;
    public boolean isAvailable = true;

    public VehicleOwner(String name, String birthDate, double balance, Vehicle vehicle) {
        super(name, birthDate, balance);
        this.vehicle = vehicle;
        this.ratePerHour = 0;
    }

    public VehicleOwner(String name, String birthDate, double balance, Vehicle vehicle, int ratePerHour) {
        super(name, birthDate, balance);
        this.vehicle = vehicle;
        this.ratePerHour = ratePerHour;
    }

    public VehicleOwner(String name, String birthDate, float balance) {
        super(name, birthDate, balance);
    }

    public int getRatePerHour() {
        return this.ratePerHour;
    }

    public void setRating(float rating) {
        this.totalTrips++;
        this.rating = (this.rating + rating) / this.totalTrips;
    }

    public float getRating() {
        return this.rating;
    }

    public boolean canAcceptHourlyRides() {
        return ratePerHour > 0;
    }
}
