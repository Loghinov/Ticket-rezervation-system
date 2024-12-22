package org.example.service.Impl;

import org.example.dao.PassengerDao;
import org.example.entity.Passenger;
import org.example.service.PassengerService;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {
    private PassengerDao passengerDao;

    public PassengerServiceImpl(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }

    @Override
     public Passenger getPassengerById(long passengerId){
        Passenger passenger = passengerDao.getById(passengerId);
        return passenger;
    }
}
