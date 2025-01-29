package org.example.controller;

import org.example.dto.SeatDto;
import org.example.service.SeatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/seat")
public class SeatController {
    private final SeatService seatService;
    public SeatController(SeatService seatService){
        this.seatService=seatService;
    }

    @GetMapping("/get-seat-by-id")
    public ResponseEntity<SeatDto> getSeatById(@RequestParam long seatId){
        try{
            SeatDto seatDto = seatService.getSeatById(seatId);
            if(seatDto==null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(seatDto, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
