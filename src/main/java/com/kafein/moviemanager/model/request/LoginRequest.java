package com.kafein.moviemanager.model.request;

import com.kafein.moviemanager.model.base.BaseRequest;
import lombok.Data;

@Data
public class LoginRequest implements BaseRequest {
    private String userName;
    private String password;
}
