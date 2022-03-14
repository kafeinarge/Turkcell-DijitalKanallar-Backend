package com.kafein.moviemanager.model.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kafein.moviemanager.model.dto.response.TokenResponse;
import lombok.Data;

@Data
public class Token {

    private boolean success;
    @JsonProperty("expires_at")
    private String expiresAt;
    @JsonProperty("request_token")
    private String requestToken;


    public Token(TokenResponse newToken) {
        this.expiresAt = newToken.getExpiresAt();
        this.success = newToken.isSuccess();
        this.requestToken = newToken.getRequestToken();
    }
}
