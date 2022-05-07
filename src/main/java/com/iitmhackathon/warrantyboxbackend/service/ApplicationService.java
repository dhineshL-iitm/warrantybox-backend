package com.iitmhackathon.warrantyboxbackend.service;

import com.iitmhackathon.warrantyboxbackend.entity.Product;
import com.iitmhackathon.warrantyboxbackend.exception.ConflictException;
import com.iitmhackathon.warrantyboxbackend.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ApplicationService {

    private ApplicationUserDetailsService applicationUserDetailsService;

    private ProductService productService;

    @Autowired
    public ApplicationService(ApplicationUserDetailsService applicationUserDetailsService, ProductService productService) {
        this.applicationUserDetailsService = applicationUserDetailsService;
        this.productService = productService;
    }

    /**
     * Creates a user if a user doesn't exist or else throws an exception
     *
     * @param user
     */
    public void createUser(UserModel user) {

        // Creates user and login
        applicationUserDetailsService.createUser(user);

    }

    public List<Product> getProduct(Principal principal){

        return productService.getProductsByUser(principal.getName());
    }

}
