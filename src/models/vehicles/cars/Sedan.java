package models.vehicles.cars;

public class Sedan extends Car {
    private final static double STARTING_FARE = 11.0;
    private final static double FARE_PER_KM = 4.0;
    private final static String CAR_TYPE = "Sedan";

    public Sedan(String make, String model, String color, int year, int price) {
        super(make, model, color, year, price, CAR_TYPE, FARE_PER_KM, STARTING_FARE);
    }
}
