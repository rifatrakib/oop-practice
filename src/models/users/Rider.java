package models.users;

import models.vehicles.Vehicle;

public class Rider extends VehicleOwner {
    public Rider(String name, String birthDate, double balance, Vehicle vehicle) {
        super(name, birthDate, balance, vehicle);
    }

    public Rider(String name, String birthDate, double balance, Vehicle vehicle, int ratePerHour) {
        super(name, birthDate, balance, vehicle, ratePerHour);
    }
}
