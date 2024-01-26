package org.mateuszosinski.people;

import org.mateuszosinski.databaseobject.DatabaseObject;

import java.time.LocalDate;

public abstract class Person extends DatabaseObject {
    private static int numberOfPeople = 1;
    private final int personId;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private LocalDate birthdate;

    public Person(String firstname, String lastname, String phoneNumber, LocalDate birthdate) {
        super("PERSON");
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;

        this.personId = numberOfPeople;
        numberOfPeople++;
    }

    public abstract String describeRole();

    public int getPersonId() {
        return personId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public static int getNumberOfPeople() {
        return numberOfPeople;
    }
}
