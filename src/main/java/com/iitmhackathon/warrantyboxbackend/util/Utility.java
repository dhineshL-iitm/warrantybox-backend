package com.iitmhackathon.warrantyboxbackend.util;

import com.iitmhackathon.warrantyboxbackend.entity.ApplicationUser;
import com.iitmhackathon.warrantyboxbackend.model.UserModel;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Utility {
    public static ApplicationUser createUserFromModel(UserModel userModel, PasswordEncoder passwordEncoder){

        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUsername(userModel.getUsername());

        // Encoding password
        applicationUser.setPassword(passwordEncoder.encode(userModel.getPassword()));

        applicationUser.setEmail(userModel.getEmail());

        applicationUser.setEnabled(true);

        if("Brand".equalsIgnoreCase(userModel.getType())) {
            applicationUser.setRoles("ROLE_BRAND");
        }

        else applicationUser.setRoles("ROLE_USER");

        applicationUser.setAccountNonExpired(true);
        applicationUser.setAccountNonLocked(true);
        applicationUser.setCredentialsNonExpired(true);

        return applicationUser;
    }
}
