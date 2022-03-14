package com.kafein.moviemanager.controller;

import com.kafein.moviemanager.constants.TmdbApiConstants;
import com.kafein.moviemanager.model.response.MovieDetailResponse;
import com.kafein.moviemanager.model.response.MovieSearchResponse;
import com.kafein.moviemanager.services.cilent.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieServiceImpl movieService;

    @GetMapping(value = "/imagine", produces = MediaType.IMAGE_JPEG_VALUE)
    private byte[] getMovie(@RequestParam(name = "file_path") String filePath){
        return movieService.getMovieImagine(filePath);
    }

    @GetMapping("/detail")
    private MovieDetailResponse getMovie(@RequestParam(name = "movie_id") Integer movieId){
        return movieService.getMovieDetail(movieId);
    }

    @GetMapping("/search")
    private MovieSearchResponse searchMovie(@RequestParam(name = "query") String query){
        return movieService.searchMovie(query);
    }
}
