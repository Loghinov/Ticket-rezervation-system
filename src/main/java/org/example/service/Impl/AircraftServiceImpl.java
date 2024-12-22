package org.example.service.Impl;

import org.example.dao.AircraftDao;
import org.example.entity.Aircraft;
import org.example.service.AircraftService;
import org.springframework.stereotype.Service;

@Service
public class AircraftServiceImpl implements AircraftService  {
    private AircraftDao aircraftDao;


    public AircraftServiceImpl(AircraftDao aircraftDao) {
        this.aircraftDao = aircraftDao;

    }

    @Override
    public Aircraft getAircraftById(long id) {
        Aircraft aircraft = aircraftDao.getById(id);

        return aircraft;
    }
}
