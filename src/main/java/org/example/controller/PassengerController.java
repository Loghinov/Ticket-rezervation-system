package org.example.controller;

import org.example.entity.Passenger;
import org.example.service.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/passenger")
public class PassengerController {
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService){
        this.passengerService=passengerService;
    }
    @GetMapping("/get-passenger-by-id")
    public ResponseEntity<Passenger> getPassengerById(@RequestParam long passengerId){
        try{
            Passenger passenger = passengerService.getPassengerById(passengerId);
            if(passenger==null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return  new ResponseEntity<>(passenger, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
