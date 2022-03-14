package com.kafein.moviemanager.model.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kafein.moviemanager.model.dto.model.Token;
import com.kafein.moviemanager.model.request.LoginRequest;
import lombok.Data;

@Data
public class LoginInfo {
    @JsonProperty("username")
    private String userName;
    private String password;
    @JsonProperty("request_token")
    private String requestToken;

    public LoginInfo(LoginRequest request, Token token) {
        this.userName = request.getUserName();
        this.password = request.getPassword();
        this.requestToken = token.getRequestToken();
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", requestToken='" + requestToken + '\'' +
                '}';
    }
}
