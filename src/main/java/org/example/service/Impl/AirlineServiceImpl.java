package org.example.service.Impl;

import org.example.dao.AirlineDao;
import org.example.entity.Airline;
import org.example.service.AirlineService;
import org.springframework.stereotype.Service;

@Service
public class AirlineServiceImpl implements AirlineService {
    private final AirlineDao airlineDao;

    public AirlineServiceImpl(AirlineDao airlineDao){
        this.airlineDao=airlineDao;
    }
    @Override
    public Airline getAirlineById(long airlineId){
        Airline airline = airlineDao.getById(airlineId);
        return airline;
    }
}
