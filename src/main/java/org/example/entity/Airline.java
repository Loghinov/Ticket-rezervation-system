package org.example.entity;

import java.util.Objects;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline= (Airline) o;
        return airlineId==airline.airlineId && airlineCode==airline.airlineCode && Objects.equals(airlineName, airline.airlineName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airlineId, airlineCode, airlineName);
    }
}

