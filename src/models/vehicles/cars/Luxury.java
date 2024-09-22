package models.vehicles.cars;

public class Luxury extends Car {
    private final static double STARTING_FARE = 23.0;
    private final static double FARE_PER_KM = 8.0;
    private final static String CAR_TYPE = "Luxury";

    public Luxury(String make, String model, String color, int year, int price) {
        super(make, model, color, year, price, CAR_TYPE, FARE_PER_KM, STARTING_FARE);
    }
}
