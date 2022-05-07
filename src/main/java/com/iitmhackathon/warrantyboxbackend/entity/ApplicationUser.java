package com.iitmhackathon.warrantyboxbackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tblUser")
@Getter
@Setter
public class ApplicationUser {
    @Id
    private String username;

    private String password;

    private boolean enabled;

    private String roles;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

}
