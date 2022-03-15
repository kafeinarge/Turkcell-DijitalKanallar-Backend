package com.kafein.moviemanager.services.cilent;

import com.kafein.moviemanager.constants.TmdbApiConstants;
import com.kafein.moviemanager.model.dto.model.AddRemoveMovieFavoriteList;
import com.kafein.moviemanager.model.dto.model.AddRemoveMovieWatchList;
import com.kafein.moviemanager.model.dto.response.AccountResponse;
import com.kafein.moviemanager.model.dto.response.FavoriteMovieResponse;
import com.kafein.moviemanager.model.dto.response.Response;
import com.kafein.moviemanager.model.dto.response.WatchListMovieResponse;
import com.kafein.moviemanager.model.request.AccountAddRemoveMovieFavoriteListRequest;
import com.kafein.moviemanager.model.request.AccountAddRemoveMovieWatchListRequest;
import com.kafein.moviemanager.model.response.*;
import com.kafein.moviemanager.utils.MovieManagerUtil;
import com.kafein.moviemanager.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class AccountServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TmdbApiConstants apiConstants;

    public AccountDetailResponse getAccount(String sessionId){
        AccountResponse clientResponse = null;
        Response errorResponse = null;
        try{
            clientResponse = restTemplate.getForObject(apiConstants.getAccountUrl(), AccountResponse.class, apiConstants.getApiKey(), sessionId);
        }catch (HttpClientErrorException e){
            log.error("Client Account response get error!", e.getMessage(), e);
            errorResponse = MovieManagerUtil.jsonStringToObjet(e.getResponseBodyAsString());
        }
        AccountDetailResponse response = new AccountDetailResponse();
        if(clientResponse != null){
            response.setAccountId(clientResponse.getAccountId());
            response.setName(clientResponse.getName());
            response.setUserName(clientResponse.getUserName());
        }
        ResponseUtil.addResultIntoResponseObj(response, errorResponse);
        return response;
    }

    public AccountFavoriteMoviesResponse getAccountFavoriteMovies(String sessionId, String accountId) {
        FavoriteMovieResponse clientResponse = null;
        Response errorResponse = null;
        try{
            clientResponse = restTemplate.getForObject(apiConstants.getAccountFavoriteMovieUrl(), FavoriteMovieResponse.class, accountId, apiConstants.getApiKey(), sessionId);
        }catch (HttpClientErrorException e){
            log.error("Client Account Favorite Movie response get error!", e.getMessage(), e);
            errorResponse = MovieManagerUtil.jsonStringToObjet(e.getResponseBodyAsString());
        }
        AccountFavoriteMoviesResponse response = new AccountFavoriteMoviesResponse();
        if(clientResponse != null){
            response.convertFromClientResponse(clientResponse);
        }
        ResponseUtil.addResultIntoResponseObj(response, errorResponse);
        return response;
    }

    public AccountWatchListMovieResponse getAccountWatchListMovies(String sessionId, String accountId) {
        WatchListMovieResponse clientResponse = null;
        Response errorResponse = null;
        try{
            clientResponse = restTemplate.getForObject(apiConstants.getAccountWatchlistMovieUrl(), WatchListMovieResponse.class, accountId, apiConstants.getApiKey(), sessionId);
        }catch (HttpClientErrorException e){
            log.error("Client Account Watch List Movie response get error!", e.getMessage(), e);
            errorResponse = MovieManagerUtil.jsonStringToObjet(e.getResponseBodyAsString());
        }
        AccountWatchListMovieResponse response = new AccountWatchListMovieResponse();
        if(clientResponse != null){
            response.convertFromClientResponse(clientResponse);
        }
        ResponseUtil.addResultIntoResponseObj(response, errorResponse);
        return response;
    }

    public AccountAddRemoveMovieWatchListResponse addRemoveAccountWatchListMovies(String sessionId, String accountId, AccountAddRemoveMovieWatchListRequest request) {
        Response clientResponse = null;
        AddRemoveMovieWatchList clientRequest = new AddRemoveMovieWatchList(request);
        try{
            clientResponse = restTemplate.postForObject(apiConstants.getAccountAddRemoveWatchlistMovieUrl(), MovieManagerUtil.generateHttpRequest(clientRequest), Response.class, accountId, apiConstants.getApiKey(), sessionId);
        }catch (HttpClientErrorException e){
            log.error("Client Add Removee Account Watch List Movie response get error!", e.getMessage(), e);
            clientResponse = MovieManagerUtil.jsonStringToObjet(e.getResponseBodyAsString());
        }
        AccountAddRemoveMovieWatchListResponse response = new AccountAddRemoveMovieWatchListResponse();
        ResponseUtil.addResultIntoResponseObj(response, clientResponse);
        return response;
    }

    public AccountAddRemoveMovieFavoriteListResponse addRemoveAccountFavoriteListMovie(String sessionId, String accountId, AccountAddRemoveMovieFavoriteListRequest request) {
        Response clientResponse = null;
        AddRemoveMovieFavoriteList clientRequest = new AddRemoveMovieFavoriteList(request);
        try{
            clientResponse = restTemplate.postForObject(apiConstants.getAccountAddRemoveFavoriteMovieUrl(), MovieManagerUtil.generateHttpRequest(clientRequest), Response.class, accountId, apiConstants.getApiKey(), sessionId);
        }catch (HttpClientErrorException e){
            log.error("Client Add Removee Account Favorite Movie response get error!", e.getMessage(), e);
            clientResponse = MovieManagerUtil.jsonStringToObjet(e.getResponseBodyAsString());
        }
        AccountAddRemoveMovieFavoriteListResponse response = new AccountAddRemoveMovieFavoriteListResponse();
        ResponseUtil.addResultIntoResponseObj(response, clientResponse);
        return response;
    }
}
