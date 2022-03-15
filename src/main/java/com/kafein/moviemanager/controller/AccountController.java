package com.kafein.moviemanager.controller;

import com.kafein.moviemanager.enums.ErrorCodeAndDesc;
import com.kafein.moviemanager.model.request.AccountAddRemoveMovieFavoriteListRequest;
import com.kafein.moviemanager.model.request.AccountAddRemoveMovieWatchListRequest;
import com.kafein.moviemanager.model.response.*;
import com.kafein.moviemanager.services.cilent.AccountServiceImpl;
import com.kafein.moviemanager.services.log.WsLogService;
import com.kafein.moviemanager.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    private static final String ACCOUNT_CONTROLLER = "ACCOUNT_CONTROLLER";

    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private WsLogService logService;

    @GetMapping("/detail")
    public AccountDetailResponse getAccountDetail(@RequestParam(name = "session_id") String sessionId){
        AccountDetailResponse response = new AccountDetailResponse();
        try{
            response = accountService.getAccount(sessionId);
        } catch (Exception e){
            log.error("[AccountController getAccountDetail method gets error: ]", e.getMessage(), e);
            ResponseUtil.addResultIntoResponseObj(response, ErrorCodeAndDesc.GENERAL_ERROR);
        } finally {
            logService.createServiceLog(response,ACCOUNT_CONTROLLER, "GET_ACCOUNT_DETAIL", HttpMethod.GET.name(),sessionId);
        }
        return response;
    }

    @GetMapping("/favorite/movies")
    public AccountFavoriteMoviesResponse getAccountFavoriteMovies(@RequestParam(name = "session_id") String sessionId, @RequestParam(name = "account_id") String accountId){
        AccountFavoriteMoviesResponse response = new AccountFavoriteMoviesResponse();
        try{
            response = accountService.getAccountFavoriteMovies(sessionId, accountId);
        } catch (Exception e){
            log.error("[AccountController getAccountFavoriteMovies method gets error: ]", e.getMessage(), e);
            ResponseUtil.addResultIntoResponseObj(response, ErrorCodeAndDesc.GENERAL_ERROR);
        } finally {
            logService.createServiceLog(response,ACCOUNT_CONTROLLER, "GET_ACCOUNT_FAVORITE_MOVIES",  HttpMethod.GET.name(), sessionId, accountId);
        }
        return response;
    }

    @PostMapping("/favorite/add_remove")
    public AccountAddRemoveMovieFavoriteListResponse addRemoveAccountFavoriteListMovie(@RequestParam(name = "session_id") String sessionId, @RequestParam(name = "account_id") String accountId, AccountAddRemoveMovieFavoriteListRequest request){
        AccountAddRemoveMovieFavoriteListResponse response = new AccountAddRemoveMovieFavoriteListResponse();
        try{
            response = accountService.addRemoveAccountFavoriteListMovie(sessionId, accountId, request);
        } catch (Exception e){
            log.error("[AccountController addRemoveAccountFavoriteListMovie method gets error: ]", e.getMessage(), e);
            ResponseUtil.addResultIntoResponseObj(response, ErrorCodeAndDesc.GENERAL_ERROR);
        } finally {
            logService.createServiceLog(response,ACCOUNT_CONTROLLER, "ADD_REMOVE_ACCOUNT_FAVORITE_MOVIES",  HttpMethod.POST.name(), sessionId,  request);
        }
        return response;
    }

    @GetMapping("/watch_list/movies")
    public AccountWatchListMovieResponse getAccountWatchListMovies(@RequestParam(name = "session_id") String sessionId, @RequestParam(name = "account_id") String accountId){
        AccountWatchListMovieResponse response = new AccountWatchListMovieResponse();
        try{
            response = accountService.getAccountWatchListMovies(sessionId, accountId);
        } catch (Exception e){
            log.error("[AccountController getAccountWatchListMovies method gets error: ]", e.getMessage(), e);
            ResponseUtil.addResultIntoResponseObj(response, ErrorCodeAndDesc.GENERAL_ERROR);
        } finally {
            logService.createServiceLog(response,ACCOUNT_CONTROLLER, "GET_ACCOUNT_WATCH_LIST_MOVIES",  HttpMethod.GET.name(), sessionId, accountId);
        }
        return response;
    }

    @PostMapping("/watch_list/add_remove")
    public AccountAddRemoveMovieWatchListResponse addRemoveAccountWatchListMovies(@RequestParam(name = "session_id") String sessionId, @RequestParam(name = "account_id") String accountId, AccountAddRemoveMovieWatchListRequest request){
        AccountAddRemoveMovieWatchListResponse response = new AccountAddRemoveMovieWatchListResponse();
        try{
            response = accountService.addRemoveAccountWatchListMovies(sessionId, accountId, request);
        } catch (Exception e){
            log.error("[AccountController addRemoveAccountWatchListMovies method gets error: ]", e.getMessage(), e);
            ResponseUtil.addResultIntoResponseObj(response, ErrorCodeAndDesc.GENERAL_ERROR);
        } finally {
            logService.createServiceLog(response,ACCOUNT_CONTROLLER, "ADD_REMOVE_ACCOUNT_WATCH_LIST_MOVIES",  HttpMethod.POST.name(), sessionId, accountId, request);
        }
        return response;
    }
}
