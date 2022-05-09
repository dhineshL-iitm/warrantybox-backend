package com.iitmhackathon.warrantyboxbackend.service;

import com.iitmhackathon.warrantyboxbackend.entity.Product;
import com.iitmhackathon.warrantyboxbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductsByUser(String username){

        return productRepository.findProductsByUsername(username);
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public Optional<Product> getProductById(String id){
        return productRepository.findById(id);
    }

    public List<Product> getTickets(String status, String username){

        return productRepository.findProductsByStatusAndUsername(status,username);
    }

    public List<Product> getTicketsByBrand(String status, String brand){

        return productRepository.findProductsByStatusAndBrand(status,brand);
    }

    public boolean existsById(String id){
        return productRepository.existsById(id);
    }
}
