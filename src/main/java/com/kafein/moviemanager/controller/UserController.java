package com.kafein.moviemanager.controller;

import com.kafein.moviemanager.enums.ErrorCodeAndDesc;
import com.kafein.moviemanager.model.request.LoginRequest;
import com.kafein.moviemanager.model.request.LogoutRequest;
import com.kafein.moviemanager.model.response.LoginResponse;
import com.kafein.moviemanager.model.response.LogoutResponse;
import com.kafein.moviemanager.services.cilent.AuthenticationServiceImpl;
import com.kafein.moviemanager.services.log.WsLogService;
import com.kafein.moviemanager.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private static final String USER_CONTROLLER = "USER_CONTROLLER";

    @Autowired
    private AuthenticationServiceImpl authenticationService;

    @Autowired
    private WsLogService logService;

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest request){
        LoginResponse response = new LoginResponse();
        try{
            response =  authenticationService.loginUser(request);
        } catch (Exception e){
            log.error("[UserController loginUser method gets error: ]", e.getMessage(), e);
            ResponseUtil.addResultIntoResponseObj(response, ErrorCodeAndDesc.GENERAL_ERROR);
        } finally {
            logService.createServiceLog(request, response, USER_CONTROLLER, "POST_USER_LOGIN");
        }
        return response;
    }

    @PostMapping("/logout")
    public LogoutResponse logoutUser(@RequestBody LogoutRequest request){
        LogoutResponse response = new LogoutResponse();
        try{
            response =  authenticationService.deleteSession(request);
        } catch (Exception e){
            log.error("[UserController logoutUser method gets error: ]", e.getMessage(), e);
            ResponseUtil.addResultIntoResponseObj(response, ErrorCodeAndDesc.GENERAL_ERROR);
        } finally {
            logService.createServiceLog(request, response, USER_CONTROLLER, "POST_USER_LOGOUT");
        }
        return response;
    }
}
