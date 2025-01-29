package org.example.controller;

import org.example.dto.BookingDto;
import org.example.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @GetMapping("/get-booking-by-id")
    public ResponseEntity<BookingDto> getBookingById(@RequestParam long bookingId){
        try{
            BookingDto bookingDto = bookingService.getBookingDtoById(bookingId);
            if( bookingDto==null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bookingDto, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/save-booking")
    public ResponseEntity<BookingDto> saveBooking(@RequestBody BookingDto booking){
        try{
            booking=bookingService.addBooling(booking);
            if(booking==null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return  new ResponseEntity<>(booking,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
