package com.iitmhackathon.warrantyboxbackend.repository;

import com.iitmhackathon.warrantyboxbackend.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser,String> {
    Optional<ApplicationUser> findByUsername(String userName);
}
