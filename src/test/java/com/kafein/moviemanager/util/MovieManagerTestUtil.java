package com.kafein.moviemanager.util;

import com.kafein.moviemanager.model.request.AccountAddRemoveMovieFavoriteListRequest;
import com.kafein.moviemanager.model.request.AccountAddRemoveMovieWatchListRequest;
import com.kafein.moviemanager.model.request.LoginRequest;
import com.kafein.moviemanager.model.request.LogoutRequest;

public class MovieManagerTestUtil {

    public static LoginRequest createLoginRequest(){
        LoginRequest request = new LoginRequest();
        request.setPassword("password");
        request.setUserName("username");
        return request;
    }

    public static LogoutRequest createLogoutRequest(){
        LogoutRequest request = new LogoutRequest();
        request.setSessionId("SESSION_ID");
        return request;
    }

    public static AccountAddRemoveMovieFavoriteListRequest createAccountAddRemoveMovieFavoriteListRequest(){
        AccountAddRemoveMovieFavoriteListRequest request = new AccountAddRemoveMovieFavoriteListRequest();
        request.setFavorite(true);
        request.setMediaId(3450);
        return request;
    }

    public static AccountAddRemoveMovieWatchListRequest createAccountAddRemoveMovieWatchListRequest(){
        AccountAddRemoveMovieWatchListRequest request = new AccountAddRemoveMovieWatchListRequest();
        request.setWatchList(true);
        request.setMediaId(3450);
        return request;
    }

}
