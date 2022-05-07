package com.iitmhackathon.warrantyboxbackend.service;

import com.iitmhackathon.warrantyboxbackend.entity.Brand;
import com.iitmhackathon.warrantyboxbackend.entity.Product;
import com.iitmhackathon.warrantyboxbackend.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@Slf4j
public class ApplicationService {

    private ApplicationUserDetailsService applicationUserDetailsService;

    private ProductService productService;

    private BrandService brandService;

    public ApplicationService(ApplicationUserDetailsService applicationUserDetailsService, ProductService productService, BrandService brandService) {
        this.applicationUserDetailsService = applicationUserDetailsService;
        this.productService = productService;
        this.brandService = brandService;
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

    public Brand addBrand(Brand brand){
        return brandService.addBrand(brand);
    }

}
