package org.example.entity;



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
}
