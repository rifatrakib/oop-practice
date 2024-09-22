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
        requestRideNotAvailable(client3, driver3, 10);

        hikeNotAvailable(client1, client2, driver2, 5);
        rentNotAvailable(client3, client1, driver4, 5);

        driverRejectRide(client1, driver4, 2.0);
        clientCancelRide(client3, driver5, 5.0);

        User[] users = {client1, client2, client3};
        Driver[] drivers = {driver1, driver2, driver3, driver4, driver5};

        // call successfulRent and successfulHike for all possible combinations of users and drivers
        for (User user : users) {
            for (Driver driver : drivers) {
                successfulRent(user, driver, 5);
                successfulHike(user, driver, 5.0);
            }
        }
    }

    public static void requestBicycleRide(User client, Driver driver, double distance) {
        System.out.println("Testing bicycle ride: should result in an failure because the driver does not provide this service.");
        Hike hike = new Hike(client, distance);

        try {
            client.requestRide(hike);
            driver.acceptRide(hike);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void requestRideInsufficientBalance(User client, Driver driver, double distance) {
        System.out.println("Testing ride with insufficient balance: should result in an failure because the client does not have enough balance.");
        Hike hike = new Hike(client, distance);

        try {
            client.requestRide(hike);
            driver.acceptRide(hike);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void requestRideNotAvailable(User client, Driver driver, int hours) {
        System.out.println("Testing ride not available: should result in an failure because the driver does not provide this service.");
        Rent rent = new Rent(client, hours);

        try {
            client.requestRide(rent);
            driver.acceptRide(rent);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void successfulHike(User client, Driver driver, double distance) {
        System.out.println("Testing successful hike.");
        Hike hike = new Hike(client, distance);

        try {
            client.requestRide(hike);
            driver.acceptRide(hike);
            hike.startRide();
            hike.endRide();
            double rating = Math.floor(Math.random() * 5 + 1);
            client.rateRide(hike, rating);
            System.out.println("Rating: " + rating);
            System.out.println("Average rating: " + driver.getRating());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void successfulRent(User client, Driver driver, int hours) {
        System.out.println("Testing successful rent.");
        Rent rent = new Rent(client, hours);

        try {
            client.requestRide(rent);
            driver.acceptRide(rent);
            rent.startRide();
            rent.endRide();
            // a random integer between 1 and 5 inclusive
            double rating = Math.floor(Math.random() * 5 + 1);
            client.rateRide(rent, rating);
            System.out.println("Rating: " + rating);
            System.out.println("Average rating: " + driver.getRating());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void hikeNotAvailable(User client1, User client2, Driver driver, double distance) {
        System.out.println("Testing hike not available: should result in an failure because the driver is not available.");
        Hike hike1 = new Hike(client1, distance);
        Hike hike2 = new Hike(client2, distance);

        try {
            client1.requestRide(hike1);
            driver.acceptRide(hike1);

            client2.requestRide(hike2);
            driver.acceptRide(hike2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void rentNotAvailable(User client1, User client2, Driver driver, int hours) {
        System.out.println("Testing rent not available: should result in an failure because the driver is not available.");
        Rent rent1 = new Rent(client1, hours);
        Rent rent2 = new Rent(client2, hours);

        try {
            client1.requestRide(rent1);
            driver.acceptRide(rent1);

            client2.requestRide(rent2);
            driver.acceptRide(rent2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void driverRejectRide(User client, Driver driver, double distance) {
        System.out.println("Testing driver reject ride.");
        Hike hike = new Hike(client, distance);

        try {
            client.requestRide(hike);
            driver.rejectRide();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void clientCancelRide(User client, Driver driver, double distance) {
        System.out.println("Testing client cancel ride.");
        Hike hike = new Hike(client, distance);

        try {
            client.requestRide(hike);
            driver.acceptRide(hike);
            client.cancelRide(hike);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
