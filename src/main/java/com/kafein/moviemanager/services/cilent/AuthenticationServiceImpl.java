package com.kafein.moviemanager.services.cilent;

import com.kafein.moviemanager.constants.TmdbApiConstants;
import com.kafein.moviemanager.model.dto.model.LoginInfo;
import com.kafein.moviemanager.model.dto.model.Session;
import com.kafein.moviemanager.model.dto.response.Response;
import com.kafein.moviemanager.model.dto.response.SessionResponse;
import com.kafein.moviemanager.model.dto.model.Token;
import com.kafein.moviemanager.model.dto.response.TokenResponse;
import com.kafein.moviemanager.model.request.LoginRequest;
import com.kafein.moviemanager.model.request.LogoutRequest;
import com.kafein.moviemanager.model.response.LoginResponse;
import com.kafein.moviemanager.model.response.LogoutResponse;
import com.kafein.moviemanager.utils.MovieManagerUtil;
import com.kafein.moviemanager.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class AuthenticationServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TmdbApiConstants apiConstants;

    public LoginResponse loginUser(LoginRequest request){
        TokenResponse newToken = getNewToken();
        LoginResponse response = new LoginResponse();
        if(!newToken.isSuccess()){
            ResponseUtil.addResultIntoResponseObj(response, newToken);
            return response;
        }
        Token token = new Token(newToken);
        TokenResponse tokenValidateLogin = validateLogin(token, request);
        if(!tokenValidateLogin.isSuccess()){
            ResponseUtil.addResultIntoResponseObj(response, tokenValidateLogin);
            return response;
        }
        SessionResponse session = createSession(token);
        if(!session.isSuccess()){
            ResponseUtil.addResultIntoResponseObj(response, session);
            return response;
        }
        response = new LoginResponse(token, session);
        return response;
    }

    public TokenResponse getNewToken(){
        TokenResponse response = null;
        Response errorResponse = null;
        try{
            response = restTemplate.getForObject(apiConstants.getNewTokenUrl(), TokenResponse.class, apiConstants.getApiKey());
        }catch (HttpClientErrorException e){
            log.error("Client new token response get error!", e.getMessage(), e);
            errorResponse = MovieManagerUtil.jsonStringToObjet(e.getResponseBodyAsString());
        }
        if(errorResponse != null) {
            response = new TokenResponse(errorResponse);
        } else {
            response.setSuccess(true);
        }
        return response;
    }

    private TokenResponse validateLogin(Token token, LoginRequest request) {
        LoginInfo loginInfo = new LoginInfo(request, token);
        TokenResponse response = null;
        Response errorResponse = null;
        try{
            response = restTemplate.postForObject(apiConstants.getValidateTokenLoginUrl(), MovieManagerUtil.generateHttpRequest(loginInfo), TokenResponse.class, apiConstants.getApiKey());
        }catch (HttpClientErrorException e){
            log.error("Client validate login response get error!", e.getMessage(), e);
            errorResponse = MovieManagerUtil.jsonStringToObjet(e.getResponseBodyAsString());
        }
        if(errorResponse != null) {
            response = new TokenResponse(errorResponse);
        } else {
            response.setSuccess(true);
        }
        return response;
    }

    private SessionResponse createSession(Token token){
        SessionResponse response = null;
        Response errorResponse = null;
        try{
            response = restTemplate.postForObject(apiConstants.getSessionUrl(), MovieManagerUtil.generateHttpRequest(token), SessionResponse.class, apiConstants.getApiKey());
        }catch (HttpClientErrorException e){
            log.error("Client create session response get error!", e.getMessage(), e);
            errorResponse = MovieManagerUtil.jsonStringToObjet(e.getResponseBodyAsString());
        }
        if(errorResponse != null) {
            response = new SessionResponse(errorResponse);
        } else {
            response.setSuccess(true);
        }
        return response;
    }

    public LogoutResponse deleteSession(LogoutRequest request){
        Session session = new Session();
        session.setSessionId(request.getSessionId());
        ResponseEntity<Response> forObject = restTemplate.exchange(apiConstants.getSessionDeleteUrl(), HttpMethod.DELETE,MovieManagerUtil.generateHttpRequest(session), Response.class, apiConstants.getApiKey());
        forObject.getBody();
        LogoutResponse response = new LogoutResponse();
        ResponseUtil.addResultIntoResponseObj(response, forObject.getBody());
        return response;
    }



}
