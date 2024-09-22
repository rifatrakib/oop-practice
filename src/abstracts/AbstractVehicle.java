package abstracts;

import interfaces.VehicleInterface;

public abstract class AbstractVehicle extends Identifier implements VehicleInterface {
    private final String brand;
    private final String model;
    private String color;
    private final int year;
    private final int price;
    private String licensePlate;
    private final AbstractVehicleType vehicleType;

    public AbstractVehicle(String brand, String model, String color, int year, int price, String vehicleType) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
        this.vehicleType = new AbstractVehicleType(vehicleType);
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public String getVehicleType() {
        return vehicleType.getType();
    }
}
