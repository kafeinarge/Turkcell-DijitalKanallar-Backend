package com.kafein.moviemanager.moviemanagertest;

import com.kafein.moviemanager.controller.UserController;
import com.kafein.moviemanager.enums.ErrorCodeAndDesc;
import com.kafein.moviemanager.model.request.LoginRequest;
import com.kafein.moviemanager.model.request.LogoutRequest;
import com.kafein.moviemanager.model.response.LoginResponse;
import com.kafein.moviemanager.model.response.LogoutResponse;
import com.kafein.moviemanager.services.cilent.AuthenticationServiceImpl;
import com.kafein.moviemanager.util.MovieManagerTestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserControllerSuccessTests {

    @Autowired
    @InjectMocks
    UserController userControllerMock;

    @Mock
    private AuthenticationServiceImpl authenticationService;

    @BeforeEach
    void mockRequests(){
        MockitoAnnotations.initMocks(this);
        mockLoginResponse();
        mockLogoutResponse();
    }

    void mockLoginResponse(){
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setResponseCode(ErrorCodeAndDesc.SUCCESS.getErrorCode());
        loginResponse.setResponseDesc(ErrorCodeAndDesc.SUCCESS.getErrorDesc());
        loginResponse.setRequestToken("NEW_TOKEN");
        loginResponse.setSessionId("NEW_SESSION_ID");

        when(authenticationService.loginUser(any(LoginRequest.class)))
                .thenReturn(loginResponse);
    }

    void mockLogoutResponse(){
        LogoutResponse logoutResponse = new LogoutResponse();
        logoutResponse.setResponseCode(ErrorCodeAndDesc.SUCCESS.getErrorCode());
        logoutResponse.setResponseDesc(ErrorCodeAndDesc.SUCCESS.getErrorDesc());

        when(authenticationService.deleteSession(any(LogoutRequest.class)))
                .thenReturn(logoutResponse);
    }

    @Test
    void loginUserTest(){
        LoginResponse response = userControllerMock.loginUser(MovieManagerTestUtil.createLoginRequest());
        Assertions.assertEquals(response.getResponseCode(), ErrorCodeAndDesc.SUCCESS.getErrorCode());
        Assertions.assertNotNull(response.getSessionId());
        Assertions.assertNotNull(response.getRequestToken());
    }

    @Test
    void logoutUserTest(){
        LogoutResponse response = userControllerMock.logoutUser(MovieManagerTestUtil.createLogoutRequest());
        Assertions.assertEquals(response.getResponseCode(), ErrorCodeAndDesc.SUCCESS.getErrorCode());
    }
}
