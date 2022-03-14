package com.kafein.moviemanager.model.request;

import com.kafein.moviemanager.model.base.BaseRequest;
import lombok.Data;

@Data
public class LogoutRequest implements BaseRequest {
    private String sessionId;
}
