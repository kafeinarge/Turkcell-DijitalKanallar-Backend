package com.kafein.moviemanager.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountResponse  {
    @JsonProperty("username")
    private String userName;
    private String name;
    @JsonProperty("id")
    private int accountId;

    public AccountResponse() {
    }
}
