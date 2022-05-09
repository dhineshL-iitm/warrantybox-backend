package com.iitmhackathon.warrantyboxbackend.repository;

import com.iitmhackathon.warrantyboxbackend.entity.SerialNoIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerialNoRepository extends JpaRepository<SerialNoIdentifier,String> {
    public List<SerialNoIdentifier> findAllByBrandName(String brandName);
}
