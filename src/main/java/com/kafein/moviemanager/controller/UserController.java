package com.kafein.moviemanager.controller;

import com.kafein.moviemanager.model.base.BaseResponse;
import com.kafein.moviemanager.model.request.LoginRequest;
import com.kafein.moviemanager.model.request.LogoutRequest;
import com.kafein.moviemanager.model.response.LoginResponse;
import com.kafein.moviemanager.model.response.LogoutResponse;
import com.kafein.moviemanager.services.cilent.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthenticationServiceImpl authenticationService;

    @PostMapping("/login")
    private LoginResponse loginUser(@RequestBody LoginRequest request){
        return authenticationService.loginUser(request);
    }

    @PostMapping("/logout")
    private LogoutResponse logoutUser(@RequestBody LogoutRequest request){
        return authenticationService.deleteSession(request);
    }
}
