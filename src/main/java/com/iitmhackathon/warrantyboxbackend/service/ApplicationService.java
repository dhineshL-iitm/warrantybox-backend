package com.iitmhackathon.warrantyboxbackend.service;

import com.iitmhackathon.warrantyboxbackend.entity.Brand;
import com.iitmhackathon.warrantyboxbackend.entity.Product;
import com.iitmhackathon.warrantyboxbackend.entity.SerialNoIdentifier;
import com.iitmhackathon.warrantyboxbackend.exception.NotFoundException;
import com.iitmhackathon.warrantyboxbackend.model.UserModel;
import com.iitmhackathon.warrantyboxbackend.repository.SerialNoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ApplicationService {

    private ApplicationUserDetailsService applicationUserDetailsService;

    private ProductService productService;

    private BrandService brandService;

    private SerialNoRepository serialNoRepository;

    @Autowired
    public ApplicationService(ApplicationUserDetailsService applicationUserDetailsService, ProductService productService, BrandService brandService, SerialNoRepository serialNoRepository) {
        this.applicationUserDetailsService = applicationUserDetailsService;
        this.productService = productService;
        this.brandService = brandService;
        this.serialNoRepository = serialNoRepository;
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

    public void addProduct(Principal principal , Product product){

        String serialNo = product.getInvoiceNo();


        if(serialNoRepository.existsById(serialNo)){
            throw new NotFoundException("Invalid Invoice");
        }

        SerialNoIdentifier serialNoIdentifier = serialNoRepository.getById(serialNo);

        Brand brand = brandService.getBrand(serialNoIdentifier.getBrandName());

        product.setBrand(brand.getName());
        product.setModel(serialNoIdentifier.getModel());
        product.setUsername(principal.getName());
        product.setStatus("None");
        product.setWarranty(serialNoIdentifier.getWarranty());

        productService.addProduct(product);
    }

    public void raiseTicket(String invoiceno, String issue){
        Optional<Product> productOpt = productService.getProductById(invoiceno);
        if(productOpt.isEmpty()){
            throw new NotFoundException("Invalid Invoice");
        }
        Product product = productOpt.get();
        product.setSeller(issue);
        product.setStatus("TICKET");

        productService.addProduct(product);
    }

    public List<Product> getTickets(Principal principal){

        return productService.getTickets("TICKET",principal.getName());
    }

    public String getRoles(Principal principal){
        System.out.println(principal+" "+ principal.getName());
        return applicationUserDetailsService.getUserType(principal.getName());
    }

    public List<Product> getTicketsByBrand(Principal principal){

        return productService.getTicketsByBrand("TICKET",principal.getName());
    }

    public void resolveTicket(String invoiceno){
        Optional<Product> productOpt = productService.getProductById(invoiceno);
        if(productOpt.isEmpty()){
            throw new NotFoundException("Invalid Invoice");
        }
        Product product = productOpt.get();
        product.setSeller("");
        product.setStatus("RESOLVED");

        productService.addProduct(product);
    }
}
