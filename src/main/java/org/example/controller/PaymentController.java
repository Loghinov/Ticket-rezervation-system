package org.example.controller;

import org.example.dto.PaymentDto;
import org.example.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }
    @GetMapping("/get-payment-by-id")

    public ResponseEntity<PaymentDto> getPaymentById(@RequestParam long paymendId){
        try{
            PaymentDto paymentDto = paymentService.getPaymentById(paymendId);
            if(paymentDto==null){
                return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(paymentDto, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
