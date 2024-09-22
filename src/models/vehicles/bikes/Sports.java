package models.vehicles.bikes;

public class Sports extends Bike {
    private final static double STARTING_FARE = 6.0;
    private final static double FARE_PER_KM = 2.0;
    private final static String CAR_TYPE = "Sports";

    public Sports(String make, String model, String color, int year, int price) {
        super(make, model, color, year, price, CAR_TYPE, FARE_PER_KM, STARTING_FARE);
    }
}
