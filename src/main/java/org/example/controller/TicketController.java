package org.example.controller;

import org.example.dto.TicketDto;
import org.example.entity.Ticket;
import org.example.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
     @PostMapping("/save-ticket")
    public  ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket){
        try{
            ticket = ticketService.addTicket(ticket);
            if(ticket ==null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return  new ResponseEntity<>(ticket,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
     }
}
