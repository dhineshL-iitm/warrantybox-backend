package com.iitmhackathon.warrantyboxbackend.service;

import com.iitmhackathon.warrantyboxbackend.entity.ApplicationUser;
import com.iitmhackathon.warrantyboxbackend.exception.ConflictException;
import com.iitmhackathon.warrantyboxbackend.model.UserModel;
import com.iitmhackathon.warrantyboxbackend.repository.ApplicationUserRepository;
import com.iitmhackathon.warrantyboxbackend.security.ApplicationUserDetails;
import com.iitmhackathon.warrantyboxbackend.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private ApplicationUserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationUserDetailsService(ApplicationUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<ApplicationUser> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException(String.format("Username %s not found",username));
        }

        return new ApplicationUserDetails(user.get());
    }

    /**
     * Creates user from userModel bean if username doesn't exist
     *
     * @param userModel
     * @return
     */
    public void createUser(UserModel userModel){

        String username = userModel.getUsername();

        if(userRepository.existsById(username)){

            throw new ConflictException(String.format("Username %s already Exists",username));
        }

        // Create User
        ApplicationUser applicationUser = Utility.createUserFromModel(userModel,passwordEncoder);
        userRepository.save(applicationUser);

    }

    public String getUserType(String username){
        Optional<ApplicationUser> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException(String.format("Username %s not found",username));
        }

        return user.get().getRoles();
    }
}
