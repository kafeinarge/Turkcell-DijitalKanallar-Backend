package com.kafein.moviemanager.constants;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Data
@Service
public class TmdbApiConstants {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.url.new.token}")
    private String newTokenUrl;

    @Value("${tmdb.api.url.validate.token.login}")
    private String validateTokenLoginUrl;

    @Value("${tmdb.api.url.session}")
    private String sessionUrl;

    @Value("${tmdb.api.url.session.delete}")
    private String sessionDeleteUrl;

    @Value("${tmdb.api.url.account}")
    private String accountUrl;

    @Value("${tmdb.api.url.account.favorite.movie}")
    private String accountFavoriteMovieUrl;

    @Value("${tmdb.api.url.account.watch.list.movie}")
    private String accountWatchlistMovieUrl;

    @Value("${tmdb.api.url.account.add.remove.watch.list.movie}")
    private String accountAddRemoveWatchlistMovieUrl;

    @Value("${tmdb.api.url.account.add.remove.favorite.movie}")
    private String accountAddRemoveFavoriteMovieUrl;

    @Value("${tmdb.api.url.imagine.path}")
    private String imagineBaseUrl;

    @Value("${tmdb.api.url.movie.detail}")
    private String movieDetail;

    @Value("${tmdb.api.url.movie.search}")
    private String searchMovie;


}
