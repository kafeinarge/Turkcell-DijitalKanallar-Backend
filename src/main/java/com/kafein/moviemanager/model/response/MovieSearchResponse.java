package com.kafein.moviemanager.model.response;

import com.kafein.moviemanager.model.base.BaseResponse;
import com.kafein.moviemanager.model.dto.model.Movie;
import com.kafein.moviemanager.model.dto.response.FavoriteMovieResponse;
import com.kafein.moviemanager.model.dto.response.SearchMovieResponse;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
@Data
public class MovieSearchResponse extends BaseResponse {
    private List<MovieType> movieList;

    public void convertFromClientResponse(SearchMovieResponse response){
        if(CollectionUtils.isEmpty(movieList)){
            movieList = new ArrayList<>();
        }
        if(response != null && !CollectionUtils.isEmpty(response.getMovieList())) {
            for (Movie movie : response.getMovieList()) {
                MovieType movieType = new MovieType(movie);
                movieList.add(movieType);
            }
        }
    }
}
