package models.users;

import abstracts.AbstractUser;

public class User extends AbstractUser {
    public User(String name, String birthDate) {
        super(name, birthDate);
    }

    public User(String name, String birthDate, double balance) {
        super(name, birthDate, balance);
    }
}
