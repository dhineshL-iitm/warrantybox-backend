package com.iitmhackathon.warrantyboxbackend.controller;

import com.iitmhackathon.warrantyboxbackend.entity.Product;
import com.iitmhackathon.warrantyboxbackend.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class ProductController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/getproducts")
    public ResponseEntity<?> getproducts(Principal principal) {
        List<Product> products = applicationService.getProduct(principal);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/addproduct")
    public ResponseEntity<?> addProduct(Principal principal,@RequestBody  Product products) {
        System.out.println("serailno");
        applicationService.addProduct(principal,products);
        return new ResponseEntity<>("Products added", HttpStatus.CREATED);
    }

    @GetMapping("/getproducts2")
    public ResponseEntity<?> getproducts2(Principal principal) {
        List<Product> products = applicationService.getProduct(principal);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/getuser")
    public ResponseEntity<?> getuser(Principal principal) {

        return new ResponseEntity<>(principal.getName(), HttpStatus.OK);
    }

    @PutMapping("/raiseticket")
    public ResponseEntity<?> raiseTicket(Principal principal , @RequestParam("invoiceNo") String invoice,@RequestParam("issue") String issue){
        applicationService.raiseTicket(principal,invoice,issue);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
