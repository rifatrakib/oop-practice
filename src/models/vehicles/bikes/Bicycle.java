package models.vehicles.bikes;

public class Bicycle extends Bike {
    private final static String CAR_TYPE = "Electric";

    public Bicycle(String make, String model, String color, int year, int price) {
        super(make, model, color, year, price, CAR_TYPE);
    }
}
