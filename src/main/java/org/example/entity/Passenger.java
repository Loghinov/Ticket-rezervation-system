package org.example.entity;

public class Passenger {
    private long passengerId;
    private String firstName;
    private String lastName;
    private long passportNumber;
    private String citizenship;
    private String phoneNumber;


    public  Passenger() {};
    public  Passenger(long passengerId, String firstName, String lastName, long passportNumber, String citizenship, String phoneNumber) {
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
        this.citizenship = citizenship;
        this.phoneNumber = phoneNumber;
    }

    public long getPassengerId() {
        return passengerId;
    }
    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public long getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(long passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Passenger id: " + passengerId + " First name: " + firstName + " Last name: " + lastName + " Passport number: " + passportNumber + " Citizenship: " + citizenship + " Phone number: " + phoneNumber;
    }
}
