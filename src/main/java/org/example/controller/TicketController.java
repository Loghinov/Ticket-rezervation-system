package org.example.controller;

import org.example.dto.TicketDto;
import org.example.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/ticket")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService){
         this.ticketService=ticketService;
    }
    @GetMapping("/get-ticket-by-id")
    public ResponseEntity<TicketDto> getTicketById(@RequestParam long ticketId){
         try{
             TicketDto ticketDto = ticketService.getTicketDtoById(ticketId);
             if(ticketDto==null){
                 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
             }
             return new ResponseEntity<>(ticketDto, HttpStatus.OK);
         }catch (Exception e){
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
     }
}
