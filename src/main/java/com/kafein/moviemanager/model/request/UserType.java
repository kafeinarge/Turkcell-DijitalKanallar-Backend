package com.kafein.moviemanager.model.request;

import lombok.Data;

@Data
public class UserType {
    private String userName;
    private String email;
    private String password;
}
