package com.kafein.moviemanager.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kafein.moviemanager.model.dto.model.Movie;
import com.kafein.moviemanager.model.dto.model.MovieDetail;
import lombok.Data;

@Data
public class MovieDetailType extends MovieType{

    private String overview;
    private long popularity;
    private String voteAverage;
    private String voteCount;

    public MovieDetailType(MovieDetail movie) {
        if(movie == null){
            return;
        }
        this.setPosterPath(movie.getPosterPath()) ;
        this.setId(movie.getId());
        this.setReleaseDate(movie.getReleaseDate());
        this.setTitle(movie.getTitle());
        this.voteCount = movie.getVoteCount();
        this.overview = movie.getOverview();
        this.popularity = movie.getPopularity();
        this.voteAverage = movie.getVoteAverage();
    }

    public MovieDetailType() {
    }
}
