package com.kafein.moviemanager.model.response;

import com.kafein.moviemanager.model.dto.model.Movie;
import lombok.Data;

@Data
public class MovieType {

    private String posterPath;
    private int id;
    private String releaseDate;
    private String title;

    public MovieType(Movie movie) {
        if(movie == null){
            return;
        }
        this.posterPath = movie.getPosterPath();
        this.id = movie.getId();
        this.releaseDate = movie.getReleaseDate();
        this.title = movie.getTitle();
    }

    public MovieType() {
    }
}
