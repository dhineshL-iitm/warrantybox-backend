package com.iitmhackathon.warrantyboxbackend.controller;

import com.iitmhackathon.warrantyboxbackend.model.UserModel;
import com.iitmhackathon.warrantyboxbackend.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class RegistrationController {

    private ApplicationService applicationService;

    @Autowired
    public RegistrationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody UserModel userModel) {
        System.out.println(userModel);
        applicationService.createUser(userModel);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="/api/v1/getusertype")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_BRAND')")
    public ResponseEntity<?> getUserType(Principal principal){

        return new ResponseEntity<>(applicationService.getRoles(principal),HttpStatus.OK);
    }

}
