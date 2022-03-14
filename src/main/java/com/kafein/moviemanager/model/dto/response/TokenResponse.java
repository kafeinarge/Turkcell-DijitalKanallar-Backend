package com.kafein.moviemanager.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TokenResponse extends Response{

    @JsonProperty("expires_at")
    private String expiresAt;
    @JsonProperty("request_token")
    private String requestToken;

    public TokenResponse(Response errorResponse) {
        this.setSuccess(errorResponse.isSuccess());
        this.setStatusCode(errorResponse.getStatusCode());
        this.setStatusMessage(errorResponse.getStatusMessage());
    }

    public TokenResponse() {
    }
}
