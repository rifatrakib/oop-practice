import models.rides.Hike;
import models.rides.Rent;
import models.users.Driver;
import models.users.User;
import models.vehicles.bikes.Bicycle;
import models.vehicles.bikes.Sports;
import models.vehicles.cars.Electric;
import models.vehicles.cars.Luxury;
import models.vehicles.cars.Sedan;

public class Main {
    public static void main(String[] args) {
        // common users
        User client1 = new User("John", "2000-01-01", 5000.0);
        User client2 = new User("Jane", "2000-01-01", 100);
        User client3 = new User("Alice", "2000-01-01", 25000.0);

        // two-wheelers
        Bicycle bicycle = new Bicycle("Phoenix", "2020", "black", 2020, 1000);
        Sports sports = new Sports("Kawasaki", "Ninja", "white-blue", 2022, 250000);

        // four-wheelers
        Sedan sedan = new Sedan("Toyota", "Corolla", "white", 2021, 2000000);
        Luxury luxury = new Luxury("Mercedes", "S-Class", "black", 2022, 5000000);
        Electric electric = new Electric("Tesla", "Model S", "red", 2022, 10000000);

        // two-wheeler owners
        Driver driver1 = new Driver("John", "2000-01-01", 50.0, bicycle);
        Driver driver2 = new Driver("Jane", "2000-01-01", 100.0, sports, 10);

        // four-wheeler owners
        Driver driver3 = new Driver("Alice", "2000-01-01", 500.0, sedan);
        Driver driver4 = new Driver("Bob", "2000-01-01", 1000.0, luxury, 50);
        Driver driver5 = new Driver("Charlie", "2000-01-01", 5000.0, electric);

        requestBicycleRide(client1, driver1, 5.0);
        requestRideInsufficientBalance(client2, driver2, 50.0);
        requestRideNotAvailable(client3, driver3, 10.0);

        successfulRent(client1, driver4, 5);
        successfulHike(client3, driver5, 5.0);

        hikeNotAvailable(client1, client2, driver2, 5);
        rentNotAvailable(client3, client1, driver4, 5);
    }

    public static void requestBicycleRide(User client, Driver driver, double distance) {
        Hike hike = new Hike(client, driver, distance);

        try {
            hike.requestRide();
            hike.acceptRide();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void requestRideInsufficientBalance(User client, Driver driver, double distance) {
        Hike hike = new Hike(client, driver, distance);

        try {
            hike.requestRide();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void requestRideNotAvailable(User client, Driver driver, double distance) {
        Rent rent = new Rent(client, driver, 5);

        try {
            rent.requestRide();
            rent.acceptRide();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void successfulHike(User client, Driver driver, double distance) {
        Hike hike = new Hike(client, driver, distance);

        try {
            hike.requestRide();
            hike.acceptRide();
            hike.startRide();
            hike.endRide();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void successfulRent(User client, Driver driver, int hours) {
        Rent rent = new Rent(client, driver, hours);

        try {
            rent.requestRide();
            rent.acceptRide();
            rent.startRide();
            rent.endRide();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void hikeNotAvailable(User client1, User client2, Driver driver, double distance) {
        Hike hike1 = new Hike(client1, driver, distance);
        Hike hike2 = new Hike(client2, driver, distance);

        try {
            hike1.requestRide();
            hike1.acceptRide();

            hike2.requestRide();
            hike2.acceptRide();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void rentNotAvailable(User client1, User client2, Driver driver, int hours) {
        Rent rent1 = new Rent(client1, driver, hours);
        Rent rent2 = new Rent(client2, driver, hours);

        try {
            rent1.requestRide();
            rent1.acceptRide();

            rent2.requestRide();
            rent2.acceptRide();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
