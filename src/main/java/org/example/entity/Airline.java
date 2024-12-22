package org.example.entity;

public class Airline {
    private long airlineId;
    private long airlineCode;
    private String airlineName;

    public Airline() {};
    public Airline(long airlineId, long airlineCode, String airlineName) {
        this.airlineId = airlineId;
        this.airlineCode = airlineCode;
        this.airlineName = airlineName;
    }

    public long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(long airlineId) {
        this.airlineId = airlineId;
    }

    public long getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(long airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    @Override
    public String toString() {
        return "Airline id: "+ airlineId +" Airline code: "+ airlineCode +" Airline name: "+ airlineName;
    }
}

