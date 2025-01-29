package org.example.service.Impl;

import org.example.dao.AirportDao;
import org.example.entity.Airport;
import org.example.service.AirportService;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService {
     private AirportDao airportDao;

     public AirportServiceImpl(AirportDao airportDao) {
         this.airportDao=airportDao;}

    @Override
    public Airport getAirportById(long airportId) {
         Airport airport =airportDao.getById(airportId);
        return airport;
    }
}
