package com.iitmhackathon.warrantyboxbackend.controller;

import com.iitmhackathon.warrantyboxbackend.model.UserModel;
import com.iitmhackathon.warrantyboxbackend.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/")
public class RegistrationController {

    private ApplicationService applicationService;

    @Autowired
    public RegistrationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping(value = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody UserModel userModel) {

        applicationService.createUser(userModel);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
