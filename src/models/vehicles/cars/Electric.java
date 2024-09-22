package models.vehicles.cars;

public class Electric extends Car {
    private final static double STARTING_FARE = 13.0;
    private final static double FARE_PER_KM = 5.0;
    private final static String CAR_TYPE = "Electric";

    public Electric(String make, String model, String color, int year, int price) {
        super(make, model, color, year, price, CAR_TYPE, FARE_PER_KM, STARTING_FARE);
    }
}
