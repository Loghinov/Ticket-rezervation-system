package org.example.dao;

import org.example.entity.Seat;

public interface SeatDao extends Dao<Seat>{
    Seat getBySeatCode (String seatCode);
}
