package models.vehicles.bikes;

import models.vehicles.Vehicle;

public class Bike extends Vehicle {
    public Bike(String brand, String model, String color, int year, int price, String bikeType) {
        super(brand, model, color, year, price, bikeType);
    }

    public Bike(String brand, String model, String color, int year, int price, String bikeType, double farePerKm, double startingFare) {
        super(brand, model, color, year, price, bikeType, farePerKm, startingFare);
    }
}
