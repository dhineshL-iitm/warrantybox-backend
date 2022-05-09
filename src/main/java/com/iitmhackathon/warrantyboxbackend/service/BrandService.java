package com.iitmhackathon.warrantyboxbackend.service;

import com.iitmhackathon.warrantyboxbackend.entity.Brand;
import com.iitmhackathon.warrantyboxbackend.entity.SerialNoIdentifier;
import com.iitmhackathon.warrantyboxbackend.repository.BrandRepository;
import com.iitmhackathon.warrantyboxbackend.repository.SerialNoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    private final BrandRepository brandRepository;
    private final SerialNoRepository serialNoRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository, SerialNoRepository serialNoRepository) {
        this.brandRepository = brandRepository;
        this.serialNoRepository = serialNoRepository;
    }

    public Brand addBrand(Brand brand){
        for(SerialNoIdentifier s :brand.getSerialno()){
            serialNoRepository.save(s);
        }
        return brandRepository.save(brand);
    }

    public Brand getBrand(String name){
        return brandRepository.getById(name);
    }
}
