package models.vehicles.cars;

import models.vehicles.Vehicle;

public class Car extends Vehicle {
    public Car(String brand, String model, String color, int year, int price, String carType, double farePerKm, double startingFare) {
        super(brand, model, color, year, price, carType, farePerKm, startingFare);
    }
}
