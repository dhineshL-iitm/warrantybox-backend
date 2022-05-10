package com.iitmhackathon.warrantyboxbackend.model;

import lombok.Data;

@Data
public class UserModel {

    private String username;
    private String password;
    private String type;
    private String email;

}
