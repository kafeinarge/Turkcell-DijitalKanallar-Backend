package com.kafein.moviemanager.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response {
    private boolean success;
    @JsonProperty("status_message")
    private String statusMessage;
    @JsonProperty("status_code")
    private int statusCode;
}
