package org.example.controller;

import org.example.entity.Aircraft;
import org.example.service.AircraftService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/aircraft")
public class AircraftController {
    private final AircraftService aircraftService;

    public AircraftController(AircraftService aircraftService){
        this.aircraftService=aircraftService;
    }
    @GetMapping("/get-aircraft-by-id")
    public ResponseEntity<Aircraft> getAircraftById(@RequestParam long aircraftId){
        try{
            Aircraft aircraft = aircraftService.getAircraftById(aircraftId);
            if(aircraft==null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(aircraft, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
