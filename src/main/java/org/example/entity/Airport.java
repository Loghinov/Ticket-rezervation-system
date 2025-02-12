package org.example.entity;

import java.util.Objects;

public class Airport {
    private long airportId;
    private long airportCode;
    private String airportName;
    private String airportCity;
    private String airportCountry;

    public Airport() {};
    public Airport(long id, long airportCode, String airportName, String airportCity, String airportCountry) {
        this.airportId = id;
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.airportCity = airportCity;
        this.airportCountry = airportCountry;
    }

    public long getAirportId() {
        return airportId;
    }

    public void setAirportId(long id) {
        this.airportId = id;
    }

    public long getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(long airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportCity() {
        return airportCity;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }

    public String getAirportCountry() {
        return airportCountry;
    }

    public void setAirportCountry(String airportCountry) {
        this.airportCountry = airportCountry;
    }

    @Override
    public String toString(){
        return "Airport id: "+airportId+" Airport code: "+airportCode+" Airport name: "+airportName+" Airport city: "+airportCity+" Airport country: "+airportCountry;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport= (Airport) o;
        return airportId==airport.airportId && airportCode== airport.airportCode && Objects.equals(airportName, airport.airportName) && Objects.equals(airportCity, airport.airportCity) && Objects.equals(airportCountry, airport.airportCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportId, airportCode, airportName, airportCity, airportCountry);
    }
}
