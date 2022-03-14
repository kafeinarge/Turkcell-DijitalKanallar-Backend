package com.kafein.moviemanager.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kafein.moviemanager.model.dto.model.Movie;
import lombok.Data;

import java.util.List;

@Data
public class FavoriteMovieResponse extends Response{

    @JsonProperty("results")
    private List<Movie> movieList;
    public FavoriteMovieResponse(Response errorResponse) {
        this.setSuccess(errorResponse.isSuccess());
        this.setStatusCode(errorResponse.getStatusCode());
        this.setStatusMessage(errorResponse.getStatusMessage());
    }

    public FavoriteMovieResponse() {
    }
}
