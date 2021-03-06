package com.iitmhackathon.warrantyboxbackend.controller;

import com.iitmhackathon.warrantyboxbackend.entity.Brand;
import com.iitmhackathon.warrantyboxbackend.entity.Product;
import com.iitmhackathon.warrantyboxbackend.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dummy/v1/user")
public class DummyController {

    private ApplicationService applicationService;

    @Autowired
    public DummyController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/getproducts")
    public ResponseEntity<?> getproducts() {
        List<Product> products = new ArrayList<>();
        Product p1 = new Product();
        p1.setBrand("Samsung");
        p1.setInvoiceNo("123ABCGHIK");
        p1.setSeller("Amazon");
        p1.setStatus("None");
        p1.setModel("Galaxy S10");
        p1.setWarranty("11-05-1999");
        Product p2 = new Product();
        p2.setBrand("Apple");
        p2.setInvoiceNo("123ZYAZQW");
        p2.setModel("iphone 12 pro");
        p2.setSeller("Flipkart");
        p2.setStatus("None");
        p2.setWarranty("11-05-1999");
        Product p3 = new Product();
        p3.setBrand("Mi");
        p3.setInvoiceNo("123ABYS23");
        p3.setModel("TV");
        p3.setSeller("Poorvika");
        p3.setStatus("None");
        p3.setWarranty("11-05-1999");

        products.add(p1);
        products.add(p2);
        products.add(p3);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/addproducts")
    public ResponseEntity<?> addProducts(@RequestBody List<Product> products) {

        return new ResponseEntity<>("Products added", HttpStatus.CREATED);
    }

    @PostMapping("/addbrand")
    public ResponseEntity<?> addBrand(@RequestBody  Brand brand){

        return new ResponseEntity<>(applicationService.addBrand(brand), HttpStatus.CREATED);
    }


    @PostMapping("/addproduct")
    public ResponseEntity<?> addProduct(Principal principal, @RequestBody  Product products) {
        applicationService.addProduct(principal,products);
        return new ResponseEntity<>("Products added", HttpStatus.CREATED);
    }
}
