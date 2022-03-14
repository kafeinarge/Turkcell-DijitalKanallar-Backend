package com.kafein.moviemanager.controller;

import com.kafein.moviemanager.model.request.AccountAddRemoveMovieFavoriteListRequest;
import com.kafein.moviemanager.model.request.AccountAddRemoveMovieWatchListRequest;
import com.kafein.moviemanager.model.response.*;
import com.kafein.moviemanager.services.cilent.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping("/detail")
    private AccountDetailResponse getAccountDetail(@RequestParam(name = "session_id") String sessionId){
        return accountService.getAccount(sessionId);
    }

    @GetMapping("/favorite/movies")
    private AccountFavoriteMoviesResponse getAccountFavoriteMovies(@RequestParam(name = "session_id") String sessionId, @RequestParam(name = "account_id") String accountId){
        return accountService.getAccountFavoriteMovies(sessionId, accountId);
    }

    @PostMapping("/favorite/add_remove")
    private AccountAddRemoveMovieFavoriteListResponse addRemoveAccountFavoriteListMovie(@RequestParam(name = "session_id") String sessionId, @RequestParam(name = "account_id") String accountId, AccountAddRemoveMovieFavoriteListRequest request){
        return accountService.addRemoveAccountFavoriteListMovie(sessionId, accountId, request);
    }

    @GetMapping("/watch_list/movies")
    private AccountWatchListMovieResponse getAccountWatchListMovies(@RequestParam(name = "session_id") String sessionId, @RequestParam(name = "account_id") String accountId){
        return accountService.getAccountWatchListMovies(sessionId, accountId);
    }

    @PostMapping("/watch_list/add_remove")
    private AccountAddRemoveMovieWatchListResponse addRemoveAccountWatchListMovies(@RequestParam(name = "session_id") String sessionId, @RequestParam(name = "account_id") String accountId, AccountAddRemoveMovieWatchListRequest request){
        return accountService.addRemoveAccountWatchListMovies(sessionId, accountId, request);
    }
}
