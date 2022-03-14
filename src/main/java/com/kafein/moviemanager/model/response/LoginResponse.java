package com.kafein.moviemanager.model.response;

import com.kafein.moviemanager.model.base.BaseResponse;
import com.kafein.moviemanager.model.dto.model.Token;
import com.kafein.moviemanager.model.dto.response.SessionResponse;
import lombok.Data;

@Data
public class LoginResponse extends BaseResponse {
    private String requestToken;
    private String sessionId;

    public LoginResponse(Token tokenValidateLogin, SessionResponse session) {
        this.requestToken = tokenValidateLogin.getRequestToken();
        this.sessionId = session.getSessionId();
    }

    public LoginResponse() {

    }
}
