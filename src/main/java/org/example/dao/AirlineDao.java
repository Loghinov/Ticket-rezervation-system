package org.example.dao;

import org.example.entity.Airline;

public interface AirlineDao extends Dao<Airline>{
    Airline getByCode (long code);

}
