package com.iitmhackathon.warrantyboxbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/getproducts")
    public List<String> restricted() {
        List<String> products = new ArrayList<>();
        products.add("iphone 12");
        products.add("beats flex earphone");
        products.add("LG monitor");
        return products;
    }
}
