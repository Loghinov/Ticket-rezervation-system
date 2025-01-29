package org.example.entity;


import java.util.Objects;

public class Aircraft {
    private long aircraftId;
    private long seatNumber;
    private long registrationNumber;
    private String model;

    public Aircraft() {};
    public Aircraft(long aircraftId, long seatNumber, long registrationNumber, String model){
        this.aircraftId = aircraftId;
        this.seatNumber = seatNumber;
        this.registrationNumber = registrationNumber;
        this.model = model;
    }

    public long getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(long aircraftId) {
        this.aircraftId = aircraftId;
    }

    public long getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(long seatNumber) {
        this.seatNumber = seatNumber;
    }

    public long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString(){
        return "Aircraft Id: "+ aircraftId +" Seat number: "+seatNumber+" Registration number: "+registrationNumber+" Model: "+model;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft= (Aircraft) o;
        return aircraftId==aircraft.aircraftId && seatNumber== aircraft.seatNumber && registrationNumber==aircraft.registrationNumber && Objects.equals(model, aircraft.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aircraftId, seatNumber, registrationNumber, model);
    }
}
