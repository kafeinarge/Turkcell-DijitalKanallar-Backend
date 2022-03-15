package com.kafein.moviemanager.controller;

import com.kafein.moviemanager.enums.ErrorCodeAndDesc;
import com.kafein.moviemanager.model.response.MovieDetailResponse;
import com.kafein.moviemanager.model.response.MovieSearchResponse;
import com.kafein.moviemanager.services.cilent.MovieServiceImpl;
import com.kafein.moviemanager.services.log.WsLogService;
import com.kafein.moviemanager.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/movie")
public class MovieController {

    private static final String MOVIE_CONTROLLER = "MOVIE_CONTROLLER";

    @Autowired
    private MovieServiceImpl movieService;

    @Autowired
    private WsLogService logService;

    @GetMapping(value = "/imagine", produces = MediaType.IMAGE_JPEG_VALUE)
    private byte[] getMovie(@RequestParam(name = "file_path") String filePath){
        return movieService.getMovieImagine(filePath);
    }

    @GetMapping("/detail")
    private MovieDetailResponse getMovie(@RequestParam(name = "movie_id") Integer movieId){
        MovieDetailResponse response = new MovieDetailResponse();
        try{
            response = movieService.getMovieDetail(movieId);
        } catch (Exception e){
            log.error("[MovieController getMovie method gets error: ]", e.getMessage(), e);
            ResponseUtil.addResultIntoResponseObj(response, ErrorCodeAndDesc.GENERAL_ERROR);
        } finally {
            logService.createServiceLog(response, MOVIE_CONTROLLER, "GET_MOVIE_DETAIL", HttpMethod.GET.name(),movieId);
        }
        return response;
    }

    @GetMapping("/search")
    private MovieSearchResponse searchMovie(@RequestParam(name = "query") String query){
        MovieSearchResponse response = new MovieSearchResponse();
        try{
            response = movieService.searchMovie(query);
        } catch (Exception e){
            log.error("[MovieController searchMovie method gets error: ]", e.getMessage(), e);
            ResponseUtil.addResultIntoResponseObj(response, ErrorCodeAndDesc.GENERAL_ERROR);
        } finally {
            logService.createServiceLog(response, MOVIE_CONTROLLER, "SEARCH_MOVIE", HttpMethod.GET.name(),query);
        }
        return response;
    }
}
