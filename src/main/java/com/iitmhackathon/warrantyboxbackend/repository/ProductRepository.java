package com.iitmhackathon.warrantyboxbackend.repository;

import com.iitmhackathon.warrantyboxbackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product,String> {

    public List<Product> findProductsByUsername(String username);

    public List<Product> findProductsByStatusAndUsername(String status, String username);

    public List<Product> findProductsByStatusAndBrand(String status, String brand);
}
