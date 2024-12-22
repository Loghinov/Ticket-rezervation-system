package org.example.service.Impl;

import org.example.dao.SeatDao;
import org.example.dto.FlightDto;
import org.example.dto.SeatDto;
import org.example.entity.Seat;
import org.example.service.FlightService;
import org.example.service.SeatService;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImpl implements SeatService {
    private SeatDao seatDao;
    private FlightService flightService;

    public SeatServiceImpl(SeatDao seatDao, FlightService flightService) {
        this.seatDao = seatDao;
        this.flightService = flightService;
    }

    @Override
    public SeatDto getSeatById(long seatId){
        Seat seat = seatDao.getById(seatId);
        FlightDto flightDto = flightService.getFlightById(seat.getFlyId());
        SeatDto seatDto = new SeatDto(seat.getSeatId(), seat.getSeatCode(), seat.getSeatAvailable(), flightDto);
        return seatDto;
    }
}
