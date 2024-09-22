package abstracts;

import interfaces.UserInterface;

import java.time.LocalDate;
import java.time.Period;

public abstract class AbstractUser extends Identifier implements UserInterface {
    private String name;
    private LocalDate birthDate;
    private double balance = 0;

    public AbstractUser(String name, String birthDate) {
        super();
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate);
    }

    public AbstractUser(String name, String birthDate, double balance) {
        super();
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate);
        this.balance = balance;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setBirthDate(String birthDate) {
        // parse string to LocalDate
        this.birthDate = LocalDate.parse(birthDate);
    }

    @Override
    public int getAge() {
        // calculate age from birthDate and current date
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public void updateBalance(double balance) {
        this.balance += balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
