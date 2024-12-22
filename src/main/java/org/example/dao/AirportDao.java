package org.example.dao;

import org.example.entity.Airport;

public interface AirportDao extends Dao<Airport>{
    Airport getByCode(long airlineCode);
}
