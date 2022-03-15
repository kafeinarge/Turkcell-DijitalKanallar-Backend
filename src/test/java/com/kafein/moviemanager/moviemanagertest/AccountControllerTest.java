package com.kafein.moviemanager.moviemanagertest;

import com.kafein.moviemanager.controller.AccountController;
import com.kafein.moviemanager.enums.ErrorCodeAndDesc;
import com.kafein.moviemanager.model.request.AccountAddRemoveMovieFavoriteListRequest;
import com.kafein.moviemanager.model.request.AccountAddRemoveMovieWatchListRequest;
import com.kafein.moviemanager.model.response.*;
import com.kafein.moviemanager.services.cilent.AccountServiceImpl;
import com.kafein.moviemanager.util.MovieManagerTestConstant;
import com.kafein.moviemanager.util.MovieManagerTestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AccountControllerTest {

    @Autowired
    @InjectMocks
    AccountController accountControllerMock;

    @Mock
    private AccountServiceImpl accountServiceMock;

    @BeforeEach
    void mockRequests() {
        MockitoAnnotations.initMocks(this);
        mockAccountDetailResponse();
        mockAccountFavoriteMoviesResponse();
        mockAccountWatchListMovieResponse();
        mockAccountAddRemoveMovieWatchListResponse();
        mockAccountAddRemoveMovieFavoriteListResponse();

    }

    void mockAccountDetailResponse() {
        AccountDetailResponse response = new AccountDetailResponse();
        response.setResponseCode(ErrorCodeAndDesc.SUCCESS.getErrorCode());
        response.setResponseDesc(ErrorCodeAndDesc.SUCCESS.getErrorDesc());
        response.setUserName("testusername");
        response.setName("TEST USER");
        response.setAccountId(1500);

        when(accountServiceMock.getAccount(any(String.class)))
                .thenReturn(response);
    }

    void mockAccountFavoriteMoviesResponse() {
        AccountFavoriteMoviesResponse response = new AccountFavoriteMoviesResponse();
        response.setResponseCode(ErrorCodeAndDesc.SUCCESS.getErrorCode());
        response.setResponseDesc(ErrorCodeAndDesc.SUCCESS.getErrorDesc());
        response.setMovieList(new ArrayList<>());
        MovieType movieType = generateMovieType();
        response.getMovieList().add(movieType);
        when(accountServiceMock.getAccountFavoriteMovies(any(String.class), any(String.class)))
                .thenReturn(response);
    }

    void mockAccountWatchListMovieResponse() {
        AccountWatchListMovieResponse response = new AccountWatchListMovieResponse();
        response.setResponseCode(ErrorCodeAndDesc.SUCCESS.getErrorCode());
        response.setResponseDesc(ErrorCodeAndDesc.SUCCESS.getErrorDesc());
        response.setMovieList(new ArrayList<>());
        MovieType movieType = generateMovieType();
        response.getMovieList().add(movieType);
        when(accountServiceMock.getAccountWatchListMovies(any(String.class), any(String.class)))
                .thenReturn(response);
    }

    void mockAccountAddRemoveMovieWatchListResponse() {
        AccountAddRemoveMovieWatchListResponse response = new AccountAddRemoveMovieWatchListResponse();
        response.setResponseCode(ErrorCodeAndDesc.SUCCESS.getErrorCode());
        response.setResponseDesc(ErrorCodeAndDesc.SUCCESS.getErrorDesc());
        when(accountServiceMock.addRemoveAccountWatchListMovies(any(String.class), any(String.class), any(AccountAddRemoveMovieWatchListRequest.class)))
                .thenReturn(response);
    }

    void mockAccountAddRemoveMovieFavoriteListResponse() {
        AccountAddRemoveMovieFavoriteListResponse response = new AccountAddRemoveMovieFavoriteListResponse();
        response.setResponseCode(ErrorCodeAndDesc.SUCCESS.getErrorCode());
        response.setResponseDesc(ErrorCodeAndDesc.SUCCESS.getErrorDesc());
        when(accountServiceMock.addRemoveAccountFavoriteListMovie(any(String.class), any(String.class), any(AccountAddRemoveMovieFavoriteListRequest.class)))
                .thenReturn(response);
    }

    private MovieType generateMovieType() {
        MovieType movieType = new MovieType();
        movieType.setId(12);
        movieType.setPosterPath("/sdfehksjdnflk.jpg");
        movieType.setReleaseDate("20-12-2020");
        movieType.setTitle("Any");
        return movieType;
    }

    @Test
    void getAccountDetailTest() {
        AccountDetailResponse response = accountControllerMock.getAccountDetail(MovieManagerTestConstant.AccountControllerTestConstant.SESSION_ID);
        Assertions.assertEquals(response.getResponseCode(), ErrorCodeAndDesc.SUCCESS.getErrorCode());
        Assertions.assertEquals("testusername", response.getUserName());
        Assertions.assertEquals("TEST USER", response.getName());
        Assertions.assertEquals(1500, response.getAccountId());
    }

    @Test
    void getAccountFavoriteMoviesTest() {
        AccountFavoriteMoviesResponse response = accountControllerMock.getAccountFavoriteMovies(MovieManagerTestConstant.AccountControllerTestConstant.SESSION_ID,
                MovieManagerTestConstant.AccountControllerTestConstant.ACCOUNT_ID);
        Assertions.assertEquals(response.getResponseCode(), ErrorCodeAndDesc.SUCCESS.getErrorCode());
        Assertions.assertNotNull(response.getMovieList());
    }

    @Test
    void getAccountWatchListMoviesTest() {
        AccountWatchListMovieResponse response = accountControllerMock.getAccountWatchListMovies(MovieManagerTestConstant.AccountControllerTestConstant.SESSION_ID,
                MovieManagerTestConstant.AccountControllerTestConstant.ACCOUNT_ID);
        Assertions.assertEquals(response.getResponseCode(), ErrorCodeAndDesc.SUCCESS.getErrorCode());
        Assertions.assertNotNull(response.getMovieList());
    }

    @Test
    void addRemoveAccountWatchListMoviesTest() {
        AccountAddRemoveMovieWatchListResponse response = accountControllerMock.addRemoveAccountWatchListMovies(MovieManagerTestConstant.AccountControllerTestConstant.SESSION_ID,
                MovieManagerTestConstant.AccountControllerTestConstant.ACCOUNT_ID, MovieManagerTestUtil.createAccountAddRemoveMovieWatchListRequest());
        Assertions.assertEquals(response.getResponseCode(), ErrorCodeAndDesc.SUCCESS.getErrorCode());
    }

    @Test
    void addRemoveAccountFavoriteListMovieTest() {
        AccountAddRemoveMovieFavoriteListResponse response = accountControllerMock.addRemoveAccountFavoriteListMovie(MovieManagerTestConstant.AccountControllerTestConstant.SESSION_ID,
                MovieManagerTestConstant.AccountControllerTestConstant.ACCOUNT_ID, MovieManagerTestUtil.createAccountAddRemoveMovieFavoriteListRequest());
        Assertions.assertEquals(response.getResponseCode(), ErrorCodeAndDesc.SUCCESS.getErrorCode());
    }


}
