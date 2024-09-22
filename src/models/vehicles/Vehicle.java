package models.vehicles;

import abstracts.AbstractVehicle;

public class Vehicle extends AbstractVehicle {
    private final double farePerKm;
    private final double startingFare;

    public Vehicle(String brand, String model, String color, int year, int price, String carType) {
        super(brand, model, color, year, price, carType);
        this.farePerKm = 0.0;
        this.startingFare = 0.0;
    }

    public Vehicle(String brand, String model, String color, int year, int price, String carType, double farePerKm, double startingFare) {
        super(brand, model, color, year, price, carType);
        this.farePerKm = farePerKm;
        this.startingFare = startingFare;
    }

    public double getFarePerKm() {
        return farePerKm;
    }

    public double getStartingFare() {
        return startingFare;
    }
}
