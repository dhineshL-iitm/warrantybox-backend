package com.iitmhackathon.warrantyboxbackend.controller;

import com.iitmhackathon.warrantyboxbackend.entity.SerialNoIdentifier;
import com.iitmhackathon.warrantyboxbackend.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/brand")
public class BrandController {
    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/gettickets")
    public ResponseEntity<?> getTickets(Principal principal){

        return new ResponseEntity<>(applicationService.getTicketsByBrand(principal),HttpStatus.OK);
    }

    @PutMapping("/resolveticket")
    public ResponseEntity<?> resolveTicket(@RequestParam("invoiceNo") String invoice){
        applicationService.resolveTicket(invoice);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addSerialNo")
    public ResponseEntity<?> addSerialNo(@RequestBody SerialNoIdentifier serialNoIdentifier){
        applicationService.saveOrUpdateSerialNo(serialNoIdentifier);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getserialno")
    public ResponseEntity<?> getSerialNo(Principal principal){
        return new ResponseEntity<>(applicationService.getAllSerialNoByBrand(principal),HttpStatus.OK);
    }
}
