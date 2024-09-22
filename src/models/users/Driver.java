package models.users;

import models.vehicles.Vehicle;

public class Driver extends VehicleOwner {
    public Driver(String name, String birthDate, double balance, Vehicle vehicle) {
        super(name, birthDate, balance, vehicle);
    }

    public Driver(String name, String birthDate, double balance, Vehicle vehicle, int ratePerHour) {
        super(name, birthDate, balance, vehicle, ratePerHour);
    }
}
