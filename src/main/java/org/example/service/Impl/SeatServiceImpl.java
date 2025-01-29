package org.example.service.Impl;

import org.example.dao.SeatDao;
import org.example.dto.SeatDto;
import org.example.entity.Aircraft;
import org.example.entity.Seat;
import org.example.service.AircraftService;

import org.example.service.SeatService;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImpl implements SeatService {
    private SeatDao seatDao;
    private AircraftService aircraftService;

    public SeatServiceImpl(SeatDao seatDao, AircraftService aircraftService) {
        this.seatDao = seatDao;
        this.aircraftService = aircraftService;
    }

    @Override
    public SeatDto getSeatById(long seatId){
        Seat seat = seatDao.getById(seatId);
        Aircraft aircraft = aircraftService.getAircraftById(seat.getAircraftId());
        SeatDto seatDto = new SeatDto(seat.getSeatId(), seat.getSeatCode(), seat.getSeatAvailable(), aircraft);
        return seatDto;
    }
}
