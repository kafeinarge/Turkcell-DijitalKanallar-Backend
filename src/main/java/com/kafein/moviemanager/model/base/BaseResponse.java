package com.kafein.moviemanager.model.base;

import lombok.Data;

@Data
public class BaseResponse {

    private int responseCode;
    private String responseDesc;

}
