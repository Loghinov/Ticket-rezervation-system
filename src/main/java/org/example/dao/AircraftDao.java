package org.example.dao;

import org.example.entity.Aircraft;


public interface AircraftDao extends Dao<Aircraft>{

    Aircraft getByRegistrationNumber(long registrationNumber);



}
