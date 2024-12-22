package org.example.dao;

import org.example.entity.Passenger;

public interface PassengerDao extends Dao<Passenger>{
    Passenger getByPassportNumber (long passportNumber);
}
