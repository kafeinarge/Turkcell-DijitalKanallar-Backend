package com.kafein.moviemanager.moviemanagertest;

import com.kafein.moviemanager.controller.MovieController;
import com.kafein.moviemanager.enums.ErrorCodeAndDesc;
import com.kafein.moviemanager.model.response.MovieDetailResponse;
import com.kafein.moviemanager.model.response.MovieSearchResponse;
import com.kafein.moviemanager.services.cilent.MovieServiceImpl;
import com.kafein.moviemanager.util.MovieManagerTestConstant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieControllerTest {

    @Autowired
    MovieController movieController;

    @Autowired
    MovieServiceImpl movieService;

    /**
     * Movie detail service test
     */
    @Test
    void getMovieDetailTest(){
        MovieDetailResponse response = movieController.getMovie(MovieManagerTestConstant.MovieControllerTestConstant.BLITZ_MOVIE_ID);
        Assertions.assertEquals(response.getResponseCode(), ErrorCodeAndDesc.SUCCESS.getErrorCode());
        Assertions.assertNotNull(response.getMovieDetailType());
        Assertions.assertNotNull(response.getMovieDetailType().getTitle());
        Assertions.assertEquals(MovieManagerTestConstant.MovieControllerTestConstant.MOVIE_NAME_BLITZ, response.getMovieDetailType().getTitle());
    }

    /**
     * Movie Search service test
     */
    @Test
    void getMovieSearchTest(){
        MovieSearchResponse response = movieController.searchMovie(MovieManagerTestConstant.MovieControllerTestConstant.MOVIE_SEARCH_TEXT);
        Assertions.assertEquals(response.getResponseCode(), ErrorCodeAndDesc.SUCCESS.getErrorCode());
        Assertions.assertNotNull(response.getMovieList());
        Assertions.assertEquals(true, response.getMovieList().stream().anyMatch(movieType -> movieType.getTitle().equals(MovieManagerTestConstant.MovieControllerTestConstant.MOVIE_NAME_BLITZ)));
    }

}
