package com.kafein.moviemanager.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SessionResponse extends Response {
    private boolean success;
    @JsonProperty("session_id")
    private String sessionId;

    public SessionResponse(Response errorResponse) {
        this.setSuccess(errorResponse.isSuccess());
        this.setStatusCode(errorResponse.getStatusCode());
        this.setStatusMessage(errorResponse.getStatusMessage());
    }

    public SessionResponse() {
    }
}
