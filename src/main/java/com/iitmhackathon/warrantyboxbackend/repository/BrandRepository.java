package com.iitmhackathon.warrantyboxbackend.repository;

import com.iitmhackathon.warrantyboxbackend.entity.ApplicationUser;
import com.iitmhackathon.warrantyboxbackend.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository  extends JpaRepository<Brand,String> {
}
