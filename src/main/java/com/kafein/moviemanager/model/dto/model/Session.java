package com.kafein.moviemanager.model.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Session {
    @JsonProperty("session_id")
    private String sessionId;

}
